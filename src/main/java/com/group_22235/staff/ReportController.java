package com.group_22235.staff;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.group_22235.generics.AController;
import com.group_22235.generics.IBaseController;

@RestController
public class ReportController extends AController<Report, Long> implements IBaseController<Report, Long>{
    
    @Autowired
    public ReportController(ReportService baseService) {
        super(baseService);
    }

    @Override
    @RequestMapping(method = RequestMethod.GET, value = "/report/{id}")
    public Report getByID(Long id) throws Exception {
        return super.getByID(id);
    }

    @Override
    @RequestMapping(method = RequestMethod.GET, value = "/reports")
    public List<Report> getAll() throws Exception {
        return super.getAll();
    }

    @Override
    public void delete(Report entity) {
        super.delete(entity);
    }

    @Override
    public void deleteByID(Long id) {
        super.deleteByID(id);
    }

}
