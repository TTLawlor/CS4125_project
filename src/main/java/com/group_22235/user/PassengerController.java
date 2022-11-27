package com.group_22235.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.group_22235.generics.AController;
import com.group_22235.generics.IBaseController;

@RestController
public class PassengerController extends AController<Passenger, Long> implements IBaseController<Passenger, Long>{
    
    @Autowired
    public PassengerController(PassengerService baseService) {
        super(baseService);
    }

    @Override
    @RequestMapping(method = RequestMethod.GET, value = "/passenger/{id}")
    public Passenger getByID(Long id) throws Exception {
        return super.getByID(id);
    } 

    @Override
    @RequestMapping(method = RequestMethod.GET, value = "/passenger")
    public List<Passenger> getAll() throws Exception {
        return super.getAll();
    }

    @Override
    public void delete(Passenger entity) {
        super.delete(entity);
    }

    @Override
    public void deleteByID(Long id) {
        super.deleteByID(id);
    }
    
}
