package com.example.task4itr.service;

import com.example.task4itr.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Pattern;

@Component
public class UserValidator implements Validator {

    @Autowired
    private UserService userService;

    private final String LATIN_LETTERS_REGEX="^[a-zA-Z0-9]+$";

    private final String EMAIL_REGEX="(?:[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"" +
            "(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*" +
            "\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]" +
            "|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:" +
            "[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;
        checkUsername(user.getUsername(), errors);
        checkEmail(user.getEMail(), errors);
        checkPassword(user.getPassword(), errors);
        checkPasswordConfirm(user.getPassword(), user.getPasswordConfirm(), errors);
    }

    private void checkUsername(String username, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "user.username.empty");
        if (!Pattern.matches(LATIN_LETTERS_REGEX, username)) {
            errors.rejectValue("username", "user.username.letters");
        }
        if (userService.findFromStorageByUserName(username) != null) {
            errors.rejectValue("username", "error.duplicate.username");
        }
    }

    private void checkEmail(String email, Errors errors) {
        if (!Pattern.matches(EMAIL_REGEX, email)) {
            errors.rejectValue("email", "user.email.invalid");
        }
        if (userService.findUserByEmail(email) != null) {
            errors.rejectValue("email", "error.duplicate.email");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "user.email.empty");
    }

    private void checkPassword(String password, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "user.password.empty");
    }

    private void checkPasswordConfirm(String password, String passwordConfirm, Errors errors) {
        if (!passwordConfirm.equals(password)) {
            errors.rejectValue("passwordConfirm", "error.passwordConfirm");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passwordConfirm", "user.passwordConfirm.empty");
    }
}