package com.company.service;

import java.util.Optional;

import com.company.entity.User;

public interface UserService {

	Optional<User> findById(Long id);

	Double calculate(Long userId, Double bill);

}
