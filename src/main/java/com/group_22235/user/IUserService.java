package com.group_22235.user;

import com.group_22235.generics.IBaseService;

import java.util.List;

public interface IUserService extends IBaseService<User, Long>{
    void saveUser(UserDto userDto);
    User findUserByEmail(String email);
    List<UserDto> findAllUsers();
}
