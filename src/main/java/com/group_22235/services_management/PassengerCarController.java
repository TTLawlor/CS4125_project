package com.group_22235.services_management;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.group_22235.generics.AController;
import com.group_22235.generics.IBaseController;

@RestController
public class PassengerCarController extends AController<ACarriage, Long> implements IBaseController<ACarriage, Long>{

    @Autowired
    public PassengerCarController(PassengerCarService carriageService) {
        super(carriageService);
    }

    @Override
    @RequestMapping(method = RequestMethod.GET, value = "/passenger_car/{id}")
    public ACarriage getByID(Long id) throws Exception {
        return super.getByID(id);
    }

    @Override
    @RequestMapping(method = RequestMethod.GET, value = "/passenger_cars")
    public List<ACarriage> getAll() throws Exception {
        return super.getAll();
    }

    @Override
    public void delete(ACarriage entity) {
        super.delete(entity);
    }

    @Override
    public void deleteByID(Long id) {
        super.deleteByID(id);
    }
    
}
