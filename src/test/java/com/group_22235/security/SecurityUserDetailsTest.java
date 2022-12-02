package com.group_22235.security;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.group_22235.user.User;

@SpringBootTest
public class SecurityUserDetailsTest {
    
    User user = new User("John Joe", "johnjoe@hibrail.ie", "password", "ROLE_MEMBER");

    @Test
    void should_get_name(){
        SecurityUserDetails sec = new SecurityUserDetails(user);
        assertEquals("John Joe", sec.getName());
    }

    @Test
    void should_get_password(){
        SecurityUserDetails sec = new SecurityUserDetails(user);
        assertEquals("password", sec.getPassword());
    }

    @Test
    void should_get_username(){
        SecurityUserDetails sec = new SecurityUserDetails(user);
        assertEquals("johnjoe@hibrail.ie", sec.getUsername());
    }
}
