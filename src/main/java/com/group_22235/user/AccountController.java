package com.group_22235.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.group_22235.generics.AController;
import com.group_22235.generics.IBaseController;

@RestController
public class AccountController extends AController<Account, Long> implements IBaseController<Account, Long>{
    
    @Autowired
    public AccountController(AccountService baseService) {
        super(baseService);
    }

    @Override
    @RequestMapping(method = RequestMethod.GET, value = "/account/{id}")
    public Account getByID(Long id) throws Exception {
        return super.getByID(id);
    }

    @Override
    @RequestMapping(method = RequestMethod.GET, value = "/accounts")
    public List<Account> getAll() throws Exception {
        return super.getAll();
    }

    @Override
    public void delete(Account entity) {
        super.delete(entity);
    }

    @Override
    public void deleteByID(Long id) {
        super.deleteByID(id);
    }
    
}
