package com.group_22235.security;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.group_22235.user.User;

// This entire class is acting as a Data Transder Object, used as an intermediate to contain new user details, but not yet saved

public class SecurityUserDetails implements UserDetails{

    private final User user;

    public SecurityUserDetails(User user){
        this.user = user;
    }

    public String getName() {
        return user.getName();
    }

    // Splits up multiple roles if listed. I.e, memeber has ROLE_GUEST and ROLE_MEMBER
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.stream(user
                                .getRoles()
                                .split(","))
                                .map(SimpleGrantedAuthority::new)
                                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    // Swapping to email here, as is the unique id for account
    @Override
    public String getUsername() {
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
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
