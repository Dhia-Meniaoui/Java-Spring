package com.project.bimapispring.secrurity.Services;

import com.project.bimapispring.models.AppUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Collection;

public class MyUserDetails implements UserDetails {

    private String username;
    private String firstName;
    private String lastname;
    private String email;
    private String password;
    private String phone;

    public MyUserDetails(AppUser appUser){
        this.username = appUser.getUsername();
        this.firstName = appUser.getFirstName();
        this.lastname = appUser.getLastname();
        this.email = appUser.getEmail();
        this.password = appUser.getPassword();
        this.phone = appUser.getPhone();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
