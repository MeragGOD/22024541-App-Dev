package com.example.securingweb.config;

import com.example.securingweb.model.Role;
import com.example.securingweb.model.User;
import com.example.securingweb.repository.RoleRepository;
import com.example.securingweb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public void run(String... args) throws Exception {

        // Tạo roles nếu chưa tồn tại
        Role adminRole = roleRepository.findByName("ADMIN"); // Không có ROLE_
        if (adminRole == null) {
            adminRole = new Role();
            adminRole.setName("ADMIN");   // Không có ROLE_
            roleRepository.save(adminRole);
        }

        Role userRole = roleRepository.findByName("USER"); // Không có ROLE_
        if (userRole == null) {
            userRole = new Role();
            userRole.setName("USER");   // Không có ROLE_
            roleRepository.save(userRole);
        }

        // Tạo admin user nếu chưa tồn tại
        User admin = userRepository.findByUsername("admin");
        if (admin == null) {
            admin = new User();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("admin")); // Mã hóa mật khẩu
            Set<Role> roles = new HashSet<>();
            roles.add(adminRole);
            admin.setRoles(roles);
            userRepository.save(admin);
        }
        // Tạo user thường nếu chưa tồn tại
        User user = userRepository.findByUsername("user");
        if (user == null) {
            user = new User();
            user.setUsername("user");
            user.setPassword(passwordEncoder.encode("user")); // Mã hóa mật khẩu
            Set<Role> roles = new HashSet<>();
            roles.add(userRole);
            user.setRoles(roles);
            userRepository.save(user);
        }
    }
}