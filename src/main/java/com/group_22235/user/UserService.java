package com.group_22235.user;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.group_22235.generics.ABaseServiceImpl;

@Service
@Transactional
public class UserService extends ABaseServiceImpl<User, Long> implements IUserService{

    public UserService(UserRepository uRepository) {
        super(uRepository);
    }
    

}
