package com.example.securingweb.service;

import com.example.securingweb.model.User;
import java.util.List;
import java.util.Optional;

public interface UserService { // Phải là interface
    List<User> getAllUsers();
    Optional<User> getUserById(Long id);
    User createUser(User user);
    Optional<User> updateUser(Long id, User user);
    boolean deleteUser(Long id);
}