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

import javax.servlet.http.HttpSession;
import java.util.Arrays;

@Controller
@RequestMapping("/")
@SessionAttributes("currentUser")
public class UsersController {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(UsersController.class);

    @Autowired
    private UserService userService;

    @GetMapping
    public String home(@AuthenticationPrincipal UserDetails user,
                       HttpSession session,
                       Model model) {
        log.info("GET request /");
        setUserInSessionAttribute(session, user);
        model.addAttribute("users", userService.allUsers());
        return "users_table";
    }

    private void setUserInSessionAttribute(HttpSession session, UserDetails user) {
        if (session.getAttribute("currentUser") == null) {
            if (!user.getUsername().equals("anonymousUser")) {
                session.setAttribute("currentUser", user);
                if (session.getAttribute("currentUser") != null) {
                    log.info("Set User in session: " + user.toString());
                }
            }
        }
    }

    @DeleteMapping("/delete")
    @ResponseBody
    public ResponseEntity<String> deleteUsers(@RequestParam("userId") Long[] usersIds) {
        log.warn("DELETE request /delete");
        Arrays.stream(usersIds).forEach(id -> userService.deleteUserById(id));
        return new ResponseEntity<>("Users deleted successfully.", HttpStatus.OK);
    }

    @PatchMapping("/unlock")
    @ResponseBody
    public ResponseEntity<String> unlockUsers(@RequestParam("userId") Long[] usersIds) {
        log.warn("PATCH request /unlock");
        Arrays.stream(usersIds).forEach(id -> userService.unlockUser(id));
        return new ResponseEntity<>("Users unlocked successfully.", HttpStatus.OK);
    }

    @PatchMapping("/block")
    @ResponseBody
    public ResponseEntity<String> blockUsers(@RequestParam("userId") Long[] usersIds) {
        log.warn("PATCH request /block");
        Arrays.stream(usersIds).forEach(id -> userService.blockUser(id));
        return new ResponseEntity<>("Users blocked successfully.", HttpStatus.OK);
    }
}
