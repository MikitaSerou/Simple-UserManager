package com.example.task4itr.service;

import com.example.task4itr.model.User;
import com.example.task4itr.repository.RoleRepository;
import com.example.task4itr.repository.UserRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;


@Service
public class UserService implements UserDetailsService {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(userName);
        if (user == null) {
            throw new UsernameNotFoundException("User with name " + userName + " is not found");
        }
        return user;
    }

    public void saveUser(User user) {
        log.info("Save User: " + user.toString());
        userRepository.save(user);
    }

    public List<User> allUsers() {
        return (List<User>) userRepository.findAll();
    }

    public User findFromStorageByUserName(String userName) {
        return userRepository.findByUsername(userName);
    }

    public User findUserByEmail(String eMail) {
        return userRepository.findByEmail(eMail);
    }

    public boolean addNewUser(User user) {
        if (userRepository.findByEmail(user.getEMail()) != null &
                userRepository.findByUsername(user.getUsername()) != null) {
            return false;
        }
        user = setInitRegistrationParameters(user);
        saveUser(user);
        return true;
    }

    public User setInitRegistrationParameters(User user) {
        user.setRole(roleRepository.findByName("ROLE_USER"));
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRegistrationDate(LocalDateTime.now(ZoneId.of("Europe/Moscow")));
        user.setLastLoginDate(LocalDateTime.now(ZoneId.of("Europe/Moscow")));
        user.setIsLocked(false);
        return user;
    }

    @Transactional
    public void setNewLoginData(String username){
        User user = (User) loadUserByUsername(username);
        user.setLastLoginDate(LocalDateTime.now(ZoneId.of("Europe/Moscow")));
        saveUser(user);
    }

    public boolean checkUserStatusByUserName(String username){
        User user = userRepository.findByUsername(username);
        return user.getLocked();
    }

    public void deleteUserById(Long id) {
        log.info("deleteUserById(Long " + id + ")");
        if (id == null) {
            log.error("User id (" + id + ") is not defined");
        } else if (!userRepository.existsById(id)){
                log.error("User with this id (" + id + ") is not exist");
        }else{
            log.info("Delete user with id: " + id);
            userRepository.deleteById(id);
        }
    }

    public void blockUser(Long userId) {
        userRepository.findById(userId)
                .ifPresentOrElse(u -> {
                    if (u.isAccountNonLocked()) {
                        u.setIsLocked(true);
                        userRepository.save(u);
                        log.info("User with Id " + userId + " has been locked");
                    }
                }, () -> log.error("User with this Id " + userId + " is not exist"));
    }

    public void unlockUser(Long userId) {
        userRepository.findById(userId).ifPresentOrElse(u -> {
            if (!u.isAccountNonLocked()) {
                u.setIsLocked(false);
                userRepository.save(u);
                log.info("User with Id " + userId + " has been unlocked");
            }
        }, () -> log.error("User with this Id " + userId + " is not exist"));
    }
}
