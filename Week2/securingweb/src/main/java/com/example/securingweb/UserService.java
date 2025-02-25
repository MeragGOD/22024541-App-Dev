package com.example.securingweb;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
//Các method khác nếu cần (ví dụ: lấy danh sách user)
}