package com.example.pharmacy_app.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pharmacy_app.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByUsername(String username);
    List<User> findByRole(String role);
}