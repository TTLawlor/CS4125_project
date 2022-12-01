package com.group_22235.booking;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.group_22235.generics.AController;
import com.group_22235.generics.IBaseController;

@RestController
public class TicketController  extends AController<TicketFacade, Long> implements IBaseController<TicketFacade, Long>{
    @Autowired
    public TicketController(TicketService baseService) {
        super(baseService);
    }

    @Override
    @RequestMapping(method = RequestMethod.GET, value = "/ticket/{id}")
    public TicketFacade getByID(Long id) throws Exception {
        return super.getByID(id);
    }

    @Override
    @RequestMapping(method = RequestMethod.GET, value = "/tickets")
    public List<TicketFacade> getAll() throws Exception {
        return super.getAll();
    }

    @Override
    public void delete(TicketFacade entity) {
        super.delete(entity);
    }

    @Override
    public void deleteByID(Long id) {
        super.deleteByID(id);
    }
}
