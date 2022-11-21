package com.group_22235.user;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.group_22235.generics.ABaseServiceImpl;

@Service
@Transactional
public class AccountService extends ABaseServiceImpl<Account, Long> implements IAccountService{
    
    public AccountService(AccountRepository aRepository) {
        super(aRepository);
    }

}
