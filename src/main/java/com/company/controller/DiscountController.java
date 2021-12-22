package com.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.service.UserService;

@RestController
@RequestMapping("/api/discountService/")
public class DiscountController {

	@Autowired
	UserService userService;

	@GetMapping(value = "calculate")
	public ResponseEntity<Double> calculate(@RequestParam Long userId, @RequestParam Double bill) {

		return  new ResponseEntity<Double>(userService.calculate(userId, bill), HttpStatus.OK);

	}

}
