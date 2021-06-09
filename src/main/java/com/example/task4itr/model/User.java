package com.example.task4itr.model;


import com.example.task4itr.enums.Role;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;

@Entity
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class User implements UserDetails{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name", nullable = false, unique = true)
    @NotEmpty(message = "{user.username.empty}")
    private String userName;

    @Column(name = "user_password", nullable = false)
    @NotEmpty(message = "{user.password.empty}")
    private String password;

    @Transient
    @NotEmpty(message = "{user.passwordConfirm.empty}")
    private String passwordConfirm;

    @Column(name = "e_mail", nullable = false, unique = true)
    @Email(message = "{user.email.invalid}")
    @NotEmpty(message = "{user.email.empty}")
    private String email;

    @Column(name = "registration_date", nullable = false)
    private LocalDate registrationDate;

    @Column(name = "last_login_date")
    private LocalDate lastLoginDate;


    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="role_id", nullable=false)
    private Role role;

    @Column(name = "account_non_locked", nullable = false)
    private Boolean isLocked;

    public User(String userName, String password, String email, LocalDate registrationDate,
                LocalDate lastLoginDate, Boolean isLocked) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.registrationDate = registrationDate;
        this.lastLoginDate = lastLoginDate;
        this.isLocked = isLocked;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(getRole());
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !isLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
