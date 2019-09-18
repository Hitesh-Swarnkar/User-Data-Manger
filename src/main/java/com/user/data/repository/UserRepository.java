package com.user.data.repository;

import org.springframework.data.repository.CrudRepository;

import com.user.data.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {
}
