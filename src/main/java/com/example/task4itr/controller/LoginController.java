package com.example.task4itr.controller;

import com.example.task4itr.model.User;
import org.slf4j.Logger;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(LoginController.class);

    @GetMapping
    public String getLoginPage(Model model) {
        SecurityContextHolder.getContext().setAuthentication(null);
        log.info("GET request /login");
        model.addAttribute("loginForm", new User());
        return "login";
    }
}
