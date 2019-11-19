package com.digitrinity.service;

import java.util.Optional;

import com.digitrinity.model.Users;

public interface UserService {
    void save(Users user);

    Users findByUsername(String username);

	Optional<Users> findById(long l);
}
