package com.example.rrest.project.Controllers;

import com.example.rrest.project.Models.User;
import com.example.rrest.project.Services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String allUsers(Model model, Principal principal) {
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("allRoles", userService.findAllRoles());
        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user1", user);
        return "admin";
    }

}