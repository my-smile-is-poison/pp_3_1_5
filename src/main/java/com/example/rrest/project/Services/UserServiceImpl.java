package com.example.rrest.project.Services;

import com.example.rrest.project.Models.Role;
import com.example.rrest.project.Models.User;
import com.example.rrest.project.dao.RoleDao;
import com.example.rrest.project.dao.UserDao;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final RoleDao roleDao;
    private final PasswordEncoder passwordEncoder;


    public UserServiceImpl(UserDao userDao, RoleDao roleDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.roleDao = roleDao;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    @Override
    public void saveUser(User user) {
        for (Role role : user.getRoles()) {
            role.setId(roleDao.findRoleByAuthority(role.getAuthority()).getId());
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.saveUser(user);
    }

    @Transactional
    @Override
    public void removeUserById(Long id) {
        userDao.removeUserById(id);
    }

    @Transactional
    @Override
    public void updateUserById(Long id, User user, Model model) {
        for (Role role : user.getRoles()) {
            role.setId(roleDao.findRoleByAuthority(role.getAuthority()).getId());
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.updateUserById(id, user);
    }

    @Transactional
    @Override
    public User showById(Long id) {
        return userDao.showById(id);
    }

    @Transactional
    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Transactional
    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    public List<Role> findAllRoles() {
        return roleDao.findAll();
    }

}