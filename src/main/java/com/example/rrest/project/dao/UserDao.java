package com.example.rrest.project.dao;

import com.example.rrest.project.Models.User;

import java.util.List;

public interface UserDao {

    void saveUser(User user);

    User showById(Long id);

    void updateUserById(Long id, User user);

    void removeUserById(Long id);

    List<User> getAllUsers();

    User findByUsername(String username);

}