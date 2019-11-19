package com.digitrinity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digitrinity.model.Users;
@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByUsername(String username);
}
