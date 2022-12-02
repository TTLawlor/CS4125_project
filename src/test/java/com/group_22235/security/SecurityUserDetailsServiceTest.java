package com.group_22235.security;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.group_22235.user.Passenger;
import com.group_22235.user.User;
import com.group_22235.user.UserService;

@SpringBootTest
public class SecurityUserDetailsServiceTest {

    @Autowired
    SecurityUserDetailsService securityUserDetailsService;

    @Autowired
    UserService userService;

    @Test
    void testLoadUserByUsername() {

        String s = securityUserDetailsService.loadUserByUsername("TestingSecurity@gmail.com").getUsername();

        assertEquals("TestingSecurity@gmail.com", securityUserDetailsService.loadUserByUsername("TestingSecurity@gmail.com").getUsername());
    }
}
