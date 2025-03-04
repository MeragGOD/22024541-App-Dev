// src/main/java/com/example/securingweb/service/UserServiceImpl.java
package com.example.securingweb.service;

import com.example.securingweb.model.User;
import com.example.securingweb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import org.springframework.transaction.annotation.Transactional;

@Service // Rất quan trọng - Đánh dấu đây là một Spring bean
public class UserServiceImpl implements UserService { // Implement UserService interface

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder; // Inject PasswordEncoder

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    @Transactional
    public User createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword())); // Mã hóa mật khẩu
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public Optional<User> updateUser(Long id, User user) {
        return userRepository.findById(id)
                .map(existingUser -> {
                    existingUser.setUsername(user.getUsername());
                    // Chỉ cập nhật mật khẩu nếu nó được cung cấp và không rỗng
                    if (user.getPassword() != null && !user.getPassword().isEmpty()) {
                        existingUser.setPassword(passwordEncoder.encode(user.getPassword()));
                    }
                    if(user.getRoles() != null){
                        existingUser.setRoles(user.getRoles());
                    }
                    return userRepository.save(existingUser);
                });
    }

    @Override
    @Transactional
    public boolean deleteUser(Long id) {
        return userRepository.findById(id)
                .map(user -> {
                    userRepository.delete(user);
                    return true;
                }).orElse(false);
    }
}