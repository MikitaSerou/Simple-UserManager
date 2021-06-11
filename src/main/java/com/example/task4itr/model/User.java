package com.example.task4itr.model;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;

@Entity
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name", nullable = false, unique = true)
    @NotEmpty(message = "{user.username.empty}")
    private String username;

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
    private LocalDateTime registrationDate;

    @Column(name = "last_login_date")
    private LocalDateTime lastLoginDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @Column(name = "account_non_locked", nullable = false)
    private Boolean isLocked;

    public User(String username, String password, String email, LocalDateTime registrationDate,
                LocalDateTime lastLoginDate, Boolean isLocked) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.registrationDate = registrationDate;
        this.lastLoginDate = lastLoginDate;
        this.isLocked = isLocked;
    }

    public User() {
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(getRole());
    }

    @Override
    public String getUsername() {
        return username;
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

    public Long getId() {
        return this.id;
    }

    public @NotEmpty(message = "{user.password.empty}") String getPassword() {
        return this.password;
    }

    public @NotEmpty(message = "{user.passwordConfirm.empty}") String getPasswordConfirm() {
        return this.passwordConfirm;
    }

    public @Email(message = "{user.email.invalid}") @NotEmpty(message = "{user.email.empty}") String getEMail() {
        return this.email;
    }

    public LocalDateTime getRegistrationDate() {
        return this.registrationDate;
    }

    public LocalDateTime getLastLoginDate() {
        return this.lastLoginDate;
    }

    public Role getRole() {
        return this.role;
    }

    public Boolean getIsLocked() {
        return this.isLocked;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getLocked() {
        return isLocked;
    }

    public void setLocked(Boolean locked) {
        isLocked = locked;
    }

    public void setUsername(@NotEmpty(message = "{user.username.empty}") String username) {
        this.username = username;
    }

    public void setPassword(@NotEmpty(message = "{user.password.empty}") String password) {
        this.password = password;
    }

    public void setPasswordConfirm(@NotEmpty(message = "{user.passwordConfirm.empty}") String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public void setEMail(@Email(message = "{user.email.invalid}") @NotEmpty(message = "{user.email.empty}") String eMail) {
        this.email = eMail;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public void setLastLoginDate(LocalDateTime lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setIsLocked(Boolean isLocked) {
        this.isLocked = isLocked;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof User)) return false;
        final User other = (User) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$username = this.getUsername();
        final Object other$username = other.getUsername();
        if (this$username == null ? other$username != null : !this$username.equals(other$username)) return false;
        final Object this$password = this.getPassword();
        final Object other$password = other.getPassword();
        if (this$password == null ? other$password != null : !this$password.equals(other$password)) return false;
        final Object this$passwordConfirm = this.getPasswordConfirm();
        final Object other$passwordConfirm = other.getPasswordConfirm();
        if (this$passwordConfirm == null ? other$passwordConfirm != null : !this$passwordConfirm.equals(other$passwordConfirm))
            return false;
        final Object this$eMail = this.getEMail();
        final Object other$eMail = other.getEMail();
        if (this$eMail == null ? other$eMail != null : !this$eMail.equals(other$eMail)) return false;
        final Object this$registrationDate = this.getRegistrationDate();
        final Object other$registrationDate = other.getRegistrationDate();
        if (this$registrationDate == null ? other$registrationDate != null : !this$registrationDate.equals(other$registrationDate))
            return false;
        final Object this$lastLoginDate = this.getLastLoginDate();
        final Object other$lastLoginDate = other.getLastLoginDate();
        if (this$lastLoginDate == null ? other$lastLoginDate != null : !this$lastLoginDate.equals(other$lastLoginDate))
            return false;
        final Object this$role = this.getRole();
        final Object other$role = other.getRole();
        if (this$role == null ? other$role != null : !this$role.equals(other$role)) return false;
        final Object this$isLocked = this.getIsLocked();
        final Object other$isLocked = other.getIsLocked();
        if (this$isLocked == null ? other$isLocked != null : !this$isLocked.equals(other$isLocked)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof User;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $username = this.getUsername();
        result = result * PRIME + ($username == null ? 43 : $username.hashCode());
        final Object $password = this.getPassword();
        result = result * PRIME + ($password == null ? 43 : $password.hashCode());
        final Object $passwordConfirm = this.getPasswordConfirm();
        result = result * PRIME + ($passwordConfirm == null ? 43 : $passwordConfirm.hashCode());
        final Object $eMail = this.getEMail();
        result = result * PRIME + ($eMail == null ? 43 : $eMail.hashCode());
        final Object $registrationDate = this.getRegistrationDate();
        result = result * PRIME + ($registrationDate == null ? 43 : $registrationDate.hashCode());
        final Object $lastLoginDate = this.getLastLoginDate();
        result = result * PRIME + ($lastLoginDate == null ? 43 : $lastLoginDate.hashCode());
        final Object $role = this.getRole();
        result = result * PRIME + ($role == null ? 43 : $role.hashCode());
        final Object $isLocked = this.getIsLocked();
        result = result * PRIME + ($isLocked == null ? 43 : $isLocked.hashCode());
        return result;
    }

    public String toString() {
        return "User(id=" + this.getId() + ", username=" + this.getUsername() + ", password=" + this.getPassword() + ", passwordConfirm=" + this.getPasswordConfirm() + ", eMail=" + this.getEMail() + ", registrationDate=" + this.getRegistrationDate() + ", lastLoginDate=" + this.getLastLoginDate() + ", role=" + this.getRole() + ", isLocked=" + this.getIsLocked() + ")";
    }
}
