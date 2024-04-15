package com.example.rrest.project.dao;

import com.example.rrest.project.Models.Role;

import java.util.List;
import java.util.NoSuchElementException;

public interface RoleDao {

    List<Role> findAll();

    Role findRoleByAuthority(String authority) throws NoSuchElementException;

}
