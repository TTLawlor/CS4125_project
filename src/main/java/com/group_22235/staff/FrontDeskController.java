package com.group_22235.staff;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.group_22235.generics.AController;
import com.group_22235.generics.IBaseController;

public class FrontDeskController extends AController<FrontDesk, Long> implements IBaseController<FrontDesk, Long>{
    
    @Autowired
    public FrontDeskController(FrontDeskService baseService) {
        super(baseService);
    }

    @Override
    @RequestMapping(method = RequestMethod.GET, value = "/frontdesk/{id}")
    public FrontDesk getByID(Long id) throws Exception {
        return super.getByID(id);
    }

    @Override
    @RequestMapping(method = RequestMethod.GET, value = "/frontdesk-employees")
    public List<FrontDesk> getAll() throws Exception {
        return super.getAll();
    }

    @Override
    public void delete(FrontDesk entity) {
        super.delete(entity);
    }

    @Override
    public void deleteByID(Long id) {
        super.deleteByID(id);
    }
    
}
