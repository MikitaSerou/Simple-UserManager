package com.example.task4itr.controller;

import com.example.task4itr.model.User;
import com.example.task4itr.service.UserService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@Controller
@RequestMapping("/")
public class UsersController {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(UsersController.class);

    @Autowired
    private UserService userService;


    @ModelAttribute("currentUser")
    public UserDetails getPerson(@AuthenticationPrincipal UserDetails user){
        return userService.findFromStorageByUserName(user.getUsername());
    }

    @GetMapping
    public String home(@AuthenticationPrincipal UserDetails user, Model model) {
        log.info("GET request /");
        model.addAttribute("currentUserStatus", !userService.checkUserStatusByUserName(user.getUsername()));
        model.addAttribute("currentUser", user);
        model.addAttribute("users", userService.allUsers());
        return "users_table";
    }

    @DeleteMapping("/delete")
    @ResponseBody
    public ResponseEntity<String> deleteUsers(@ModelAttribute("currentUser") User user,
                                              @RequestParam("userId") Long[] usersIds) {
        log.warn("DELETE request /delete");
        if (user.getIsLocked()){
            return new ResponseEntity<>("Current User is locked.", HttpStatus.LOCKED);
        }
        Arrays.stream(usersIds).forEach(id -> userService.deleteUserById(id));
        return new ResponseEntity<>("Users deleted successfully.", HttpStatus.OK);
    }

    @PatchMapping("/unlock")
    @ResponseBody
    public ResponseEntity<String> unlockUsers(@ModelAttribute("currentUser") User user,
            @RequestParam("userId") Long[] usersIds) {
        log.warn("PATCH request /unlock");
        if (user.getIsLocked()){
            return new ResponseEntity<>("Current User is locked.", HttpStatus.LOCKED);
       }
        Arrays.stream(usersIds).forEach(id -> userService.unlockUser(id));
        return new ResponseEntity<>("Users unlocked successfully.", HttpStatus.OK);
    }

    @PatchMapping("/block")
    @ResponseBody
    public ResponseEntity<String> blockUsers(@ModelAttribute("currentUser") User user,
            @RequestParam("userId") Long[] usersIds) {
        log.warn("PATCH request /block");
        if (user.getIsLocked()){
            return new ResponseEntity<>("Current User is locked.", HttpStatus.LOCKED);
        }
        Arrays.stream(usersIds).forEach(id -> userService.blockUser(id));
        return new ResponseEntity<>("Users blocked successfully.", HttpStatus.OK);
    }
}

