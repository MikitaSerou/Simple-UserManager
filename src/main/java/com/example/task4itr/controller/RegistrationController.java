package com.example.task4itr.controller;

import com.example.task4itr.model.User;
import com.example.task4itr.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/registration")
@Slf4j
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String registration(Model model) {
        log.info("GET request /registration");
        model.addAttribute("userForm", new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@ModelAttribute("registrationForm") @Valid User registrationForm,
                          BindingResult bindingResult,
                          Model model){
        if (bindingResult.hasErrors()){
            return "registration";
        }
        if (!registrationForm.getPassword().equals(registrationForm.getPasswordConfirm())){
            model.addAttribute("passwordsError", "password.match.error");
            return "registration";
        }
        if(!userService.saveUser(registrationForm)){
            model.addAttribute("notUniqueError", "unique.error");
            return "registration";
        }
        return "redirect:/"; //TODO Возможно изменятся URL
    }
}
