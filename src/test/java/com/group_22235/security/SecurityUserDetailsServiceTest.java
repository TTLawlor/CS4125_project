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
        User user = new Passenger("John", "bigtest@gmail.com", "test", 6);
        userService.save(user);

        String s = securityUserDetailsService.loadUserByUsername("bigtest@gmail.com").getUsername();

        assertEquals("bigtest@gmail.com", securityUserDetailsService.loadUserByUsername("bigtest@gmail.com").getUsername());
    }
}
