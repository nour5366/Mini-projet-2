package com.nour.series.service;

import com.nour.series.entites.Role;
import com.nour.series.entites.User;

public interface UserService {
    void deleteAllusers();
    void deleteAllRoles();
    User saveUser(User user);
    User findUserByUsername(String username);
    Role addRole(Role role);
    User addRoleToUser(String username, String rolename);
}
