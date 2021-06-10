package com.example.task4itr.service;

import com.example.task4itr.model.User;
import com.example.task4itr.repository.RoleRepository;
import com.example.task4itr.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    PasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(userName);
        if (user == null) {
            throw new UsernameNotFoundException("User with name " + userName + " is not found");
        }
        return user;
    }

    public User findUserByID(Long userId) {
        Optional<User> userFromDB = userRepository.findById(userId);
        return userFromDB.orElse(new User());
    }

    public List<User> allUsers() {
        return (List<User>) userRepository.findAll();
    }

    public boolean saveUser(User user) {
        if (userRepository.findByEmail(user.getEMail()) != null &
                userRepository.findByUsername(user.getUsername()) != null) {
            return false;
        }
        user = setInitRegistrationParameters(user);
        userRepository.save(user);
        return true;
    }

    public User setInitRegistrationParameters(User user) {
        user.setRole(roleRepository.findByName("ROLE_USER"));
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRegistrationDate(LocalDate.now());
        user.setIsLocked(false);
        return user;
    }

    public boolean deleteUser(Long userId) {
        if (userRepository.findById(userId).isPresent()) {
            userRepository.deleteById(userId);
            return true;
        }
        return false;
    }

    public void lockUser(Long userId) {
        userRepository.findById(userId)
                .ifPresentOrElse(u -> {
                    if (u.isAccountNonLocked()) {
                        u.setIsLocked(true);
                        log.info("User with Id " + userId + " has been locked");
                    }
                }, () -> log.error("User with this Id " + userId + " is not exist"));
    }

    private void unlockUser(Long userId) {
        userRepository.findById(userId).ifPresentOrElse(u -> {
            if (!u.isAccountNonLocked()) {
                u.setIsLocked(false);
                log.info("User with Id " + userId + " has been unlocked");
            }
        }, () -> log.error("User with this Id " + userId + " is not exist"));
    }
}
