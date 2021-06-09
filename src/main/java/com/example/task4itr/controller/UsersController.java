package com.example.task4itr.controller;

import com.example.task4itr.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@Slf4j
public class UsersController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/")
    public String home() {

       // userRepository.save(user);
        log.info("GET request /");
        return "users_table";
    }


}
