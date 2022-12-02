package com.group_22235.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTest {

    UserService userService;

    @Autowired
    public UserServiceTest(UserService uService) {
        this.userService = uService;
    }

    @Test
    void testFindAllUsers() {

    }

    @Test
    void testFindUserByEmail() {
        assertEquals("TestingSecurity@gmail.com", userService.findUserByEmail("TestingSecurity@gmail.com").getEmail());
    }
}
