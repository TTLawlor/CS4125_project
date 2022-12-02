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
        assertEquals("badmintest@gmail.com", userService.findUserByEmail("badmintest@gmail.com").getEmail());
    }

    @Test
    void testSaveUser() {
        //userService = new UserService(null, null);
        UserDto userDto = new UserDto(2, "John", "usertest@gmail.com", "testing");
        assertNotNull(userService);

        //User user = new User("Tomo", "youbo@gmail.com", "test", "ROLE_ADMIN");
        //userService.save(user);
        userService.saveUser(userDto);


        
        assertNotNull(userService.findUserByEmail(userDto.getEmail()));
    }
}
