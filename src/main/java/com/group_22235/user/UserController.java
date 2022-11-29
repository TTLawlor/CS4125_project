package com.group_22235.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.group_22235.generics.AController;
import com.group_22235.generics.IBaseController;

@RestController
public class UserController extends AController<User, Long> implements IBaseController<User, Long>{

    @Autowired
    public UserController(UserService baseService) {
        super(baseService);
    }

    @Override
    @RequestMapping(method = RequestMethod.GET, value = "/user/{id}")
    public User getByID(Long id) throws Exception {
        return super.getByID(id);
    }

    @Override
    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public List<User> getAll() throws Exception {
        return super.getAll();
    }

    @Override
    public void delete(User entity) {
        super.delete(entity);
    }

    @Override
    public void deleteByID(Long id) {
        super.deleteByID(id);
    }
    
}