package com.nour.users.service;

import com.nour.users.entities.Role;
import com.nour.users.entities.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    User findUserByUsername(String username);
    Role addRole(Role role);
    Role findRoleByName(String rolename);
    User addRoleToUser(String username, String rolename);
    List<User> findAllUsers();
}
