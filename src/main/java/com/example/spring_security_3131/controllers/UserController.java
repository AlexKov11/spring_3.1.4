package com.example.spring_security_3131.controllers;


import com.example.spring_security_3131.entities.User;
import com.example.spring_security_3131.repositories.UserRepo;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class UserController {
    private final UserRepo userRepo;

    public UserController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping("/user")
    public String showUser(Model model, Principal principal) {
        User user = userRepo.findByUsername(principal.getName());
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        model.addAttribute("user", user);
        return "showuser";
    }
}
