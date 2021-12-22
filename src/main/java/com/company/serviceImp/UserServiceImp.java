package com.company.serviceImp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.entity.Customer;
import com.company.entity.Employee;
import com.company.entity.User;
import com.company.repository.UserRepository;
import com.company.service.UserService;

@Service
public class UserServiceImp implements UserService {

	static final String CUSTOMER = "Customer";
	static final String EMPLOYEE = "Employee";

	@Autowired
	UserRepository userRepository;

	@Override
	public Optional<User> findById(Long id) {
		return userRepository.findById(id);
	}

	@Override
	public Double calculate(Long userId, Double bill) {

		User user = findById(userId).orElse(new User());

		if (user.getUserType().equals(CUSTOMER)) {
			Customer customer = (Customer) user;
			return calculateDiscount(customer.getDiscountRate(), bill);
		}

		if (user.getUserType().equals(EMPLOYEE)) {
			Employee employee = (Employee) user;
			return calculateDiscount(employee.getDiscountRate(), bill);

		}
		return bill;

	}

	private Double calculateDiscount(Double discountRate, Double bill) {
		Double payableAmount = bill - (bill * discountRate);

		if (bill == 100) {
			return payableAmount + 5.0;
		} else if (bill > 100) {
			return calculateAdditionalDiscount(bill) + payableAmount;
		} else
			return payableAmount;

	}

	private Double calculateAdditionalDiscount(Double payableAmount) {
		Integer additionalDiscount = (payableAmount.intValue() / 100) * 5;

		return additionalDiscount.doubleValue();
	}

}
