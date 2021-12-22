package com.company.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.company.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
