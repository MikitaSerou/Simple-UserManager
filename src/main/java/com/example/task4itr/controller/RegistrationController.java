package com.example.task4itr.controller;

import com.example.task4itr.model.User;
import com.example.task4itr.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
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
@Slf4j
public class RegistrationController {

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @Autowired
    AuthenticationManager authenticationManager;

    @GetMapping
    public String registration(Model model) {
        log.info("GET request /registration");
        model.addAttribute("registrationForm", new User());
        return "registration";
    }

    @PostMapping
    public String addUser(@ModelAttribute("registrationForm") @Valid User registrationForm,
                          BindingResult bindingResult,
                          HttpServletRequest request,
                          Model model) {
        String notEncryptedPass = registrationForm.getPassword();

        //TODO вынести валидацию в отдельный класс
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        if (!registrationForm.getPassword().equals(registrationForm.getPasswordConfirm())) {
            model.addAttribute("passwordsError", "password.match.error");
            return "registration";
        }
        if (!userService.addNewUser(registrationForm)) {
            model.addAttribute("notUniqueError", "unique.error");
            return "registration";
        }
        authenticateUser(registrationForm.getUsername(), notEncryptedPass, request);
        return "redirect:/";
    }

    private void authenticateUser(String username, String password, HttpServletRequest request) {
        try {
            request.login(username, password);
        } catch (ServletException ex) {
            ex.printStackTrace();
        }
    }
}
