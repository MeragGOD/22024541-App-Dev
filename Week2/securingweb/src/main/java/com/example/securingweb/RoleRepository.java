// src/main/java/com/example/securingweb/repository/RoleRepository.java
package com.example.securingweb;

import com.example.securingweb.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name); // Tìm role theo tên
}