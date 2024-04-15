package com.example.rrest.project.Services;

import com.example.rrest.project.Models.Role;
import com.example.rrest.project.Models.User;
import org.springframework.ui.Model;

import java.util.List;

public interface UserService {

    void saveUser(User user);

    void removeUserById(Long id);

    void updateUserById(Long id, User user, Model model);

    User showById(Long id);

    List<User> getAllUsers();

    User findByUsername(String username);

    List<Role> findAllRoles();
}
