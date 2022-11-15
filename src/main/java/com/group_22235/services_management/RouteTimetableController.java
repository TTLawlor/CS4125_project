package com.group_22235.services_management;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.group_22235.generics.AController;
import com.group_22235.generics.IBaseController;

@RestController
public class RouteTimetableController extends AController<RouteTimetable, Long> implements IBaseController<RouteTimetable, Long>{

    @Autowired
    public RouteTimetableController(RouteTimetableService baseService) {
        super(baseService);
    }

    @Override
    @RequestMapping(method = RequestMethod.GET, value = "/route/{id}")
    public RouteTimetable getByID(Long id) throws Exception {
        return super.getByID(id);
    }

    @Override
    @RequestMapping(method = RequestMethod.GET, value = "/routes")
    public List<RouteTimetable> getAll() throws Exception {
        return super.getAll();
    }

    @Override
    public void delete(RouteTimetable entity) {
        super.delete(entity);
    }

    @Override
    public void deleteByID(Long id) {
        super.deleteByID(id);
    }
    
}
