package com.example.spring_security_3131.service;

import com.example.spring_security_3131.entities.Role;
import com.example.spring_security_3131.entities.User;

import java.util.List;
import java.util.Set;

public interface UserServ {
    List<User> getAllUsers();

    boolean saveUser(User user);

    void createRolesIfNotExist();

    boolean updateUser(User updateUser, Set<Role> roles);

    User showUser(Long id);

    void deleteUser(Long id);

}
