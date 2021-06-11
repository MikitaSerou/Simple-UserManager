package com.example.task4itr.controller;

import com.example.task4itr.model.User;
import com.example.task4itr.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
@Slf4j
public class UsersController {

    @Autowired
    UserService userService;

    @GetMapping
    public String home(@AuthenticationPrincipal UserDetails user,
                       Model model) {
        log.info("GET request /");
        model.addAttribute("currentUser", user);
        model.addAttribute("users", userService.allUsers());
        deleteAuthenticationWhenUserHasBeenDeleted((User) user);
        return "users_table";
    }

    @DeleteMapping("/delete")
    @ResponseBody
    public ResponseEntity<String> deleteUsers(@RequestParam("userId") Long[] usersIds, Model model) { //TODO обозвать по другому
        log.warn("DELETE request /delete");
        UserDetails u = (UserDetails) model.getAttribute("currentUser");
        for (Long id : usersIds) {
         userService.deleteUserById(id);
        }
        return new ResponseEntity<>("Users deleted successfully.", HttpStatus.OK);
    }

    private void deleteAuthenticationWhenUserHasBeenDeleted(User currentUser){
        if (userService.findUserByID(currentUser.getId()) == null){
            SecurityContextHolder.getContext().setAuthentication(null);
        }
    }

}
