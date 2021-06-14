package com.example.task4itr.controller;

import com.example.task4itr.model.User;
import com.example.task4itr.service.UserService;
import com.example.task4itr.service.UserValidator;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(RegistrationController.class);

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @Autowired
    private UserValidator userValidator;

    @GetMapping
    public String registration(Model model) {
        log.info("GET request /registration");
        model.addAttribute("registrationForm", new User());
        return "registration";
    }

    @PostMapping
    public String addUser(@ModelAttribute("registrationForm") @Valid User registrationForm,
                          BindingResult bindingResult,
                          HttpServletRequest request) {
        String notEncryptedPass = registrationForm.getPassword();
        userValidator.validate(registrationForm, bindingResult);
        if (bindingResult.hasErrors()) {
            log.error("Registration form has invalid values");
            return "registration";
        }
        if (!userService.addNewUser(registrationForm)) {
            return "registration";
        }
        authenticateUser(registrationForm.getUsername(), notEncryptedPass, request);
        return "redirect:/";
    }

    private void authenticateUser(String username, String password, HttpServletRequest request) {
        SecurityContextHolder.getContext().setAuthentication(null);
        log.info("User authentication: " + username);
        try {
            request.login(username, password);
        } catch (ServletException ex) {
            ex.printStackTrace();
        }
    }
}
