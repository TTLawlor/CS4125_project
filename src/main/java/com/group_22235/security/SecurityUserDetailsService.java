package com.group_22235.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.group_22235.user.User;
import com.group_22235.user.UserRepository;

@Service
public class SecurityUserDetailsService implements UserDetailsService{

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByEmail(email);    // Try to find the email in the db using userRepo
        user.orElseThrow(() -> new UsernameNotFoundException("Email not found: " + email));     // If not found, throw error
         // If found, maps the user details to type SecurityUserDetails. Can't just throw back type User, since requires UserDetails 
         // type return, so we convert it
        return user.map(SecurityUserDetails::new).get(); 
    }    
}
