package com.example.task4itr.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name", nullable = false)
    @NotEmpty(message = "{user.username.empty}")
    private String userName;

    @Column(name = "user_password", nullable = false)
    @NotEmpty(message = "{user.password.empty}")
    private String password;

    @Transient
    @NotEmpty(message = "{user.passwordConfirm.empty}")
    private String passwordConfirm;

    @Column(name = "e_mail", nullable = false)
    @Email(message = "{user.email.invalid}")
    @NotEmpty(message = "{user.email.empty}")
    private String email;

    @Column(name = "registration_date", nullable = false)
    private LocalDate registrationDate;

    @Column(name = "last_login_date")
    private LocalDate lastLoginDate;

    @Column(name = "active", nullable = false)
    private Boolean isActive;

    public User(String userName, String password, String email, LocalDate registrationDate,
                LocalDate lastLoginDate, Boolean isActive) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.registrationDate = registrationDate;
        this.lastLoginDate = lastLoginDate;
        this.isActive = isActive;
    }

}
