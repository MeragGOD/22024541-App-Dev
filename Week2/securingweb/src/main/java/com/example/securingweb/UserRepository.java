// src/main/java/com/example/securingweb/repository/UserRepository.java
package com.example.securingweb;

import com.example.securingweb.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username); // Phương thức quan trọng để tìm user theo username
}