// src/main/java/com/example/securingweb/repository/UserRepository.java
package com.example.securingweb.repository;

import com.example.securingweb.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username); // Phương thức quan trọng để tìm user theo username
}