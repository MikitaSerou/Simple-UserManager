package com.example.task4itr.controller;

import com.example.task4itr.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@Slf4j
public class UsersController {

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public String home(@AuthenticationPrincipal UserDetails user,
                       Model model) {
        model.addAttribute("currentUser", user);
        model.addAttribute("users", userRepository.findAll());
        log.info("GET request /");
        return "users_table";
    }
}
