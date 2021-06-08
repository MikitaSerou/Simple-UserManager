package com.example.task4itr.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "user_password", nullable = false)
    private String password;

    @Column(name = "e_mail", nullable = false)
    private String email;

    @Column(name = "registration_date", nullable = false)
    private LocalDate registrationDate;

    @Column(name = "last_login_date")
    private LocalDate lastLoginDate;

    @Column(name = "active", nullable = false)
    private Boolean isActive;

}
