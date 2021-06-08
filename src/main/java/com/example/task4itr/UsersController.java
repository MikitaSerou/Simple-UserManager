package com.example.task4itr;

import com.example.task4itr.model.User;
import com.example.task4itr.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
@RequestMapping("/")
@Slf4j
public class UsersController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/")
    public String home() {
        User user = new User("Nikita","kek",
                "mikita.serou@gmail.com", LocalDate.now(), LocalDate.now(), true);
        log.error(user.toString());
       // userRepository.save(user);
        log.info("Hello controller");
        return "users_table";
    }
}
