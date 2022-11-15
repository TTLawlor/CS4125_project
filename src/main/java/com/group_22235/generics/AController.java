package com.group_22235.generics;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public abstract class AController<T extends ABaseEntity, ID> {
    private IBaseService<T, ID> baseService;

    public AController(IBaseService<T, ID> baseService) {
        this.baseService = baseService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<T> getAll() throws Exception {
        return baseService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public T getByID(ID id) throws Exception {
        return baseService.findById(id);
    }

    // @RequestMapping(method = RequestMethod.POST)
    public T post(T entity) {
        return baseService.save(entity);
    }

    public T updateDetails(T entity) {
        return baseService.update(entity);
    }

    public T updateDetailsByID(ID id) {
        return baseService.updateById(id);
    }

    public void delete(T entity) {
        baseService.delete(entity);
    }

    public void deleteByID(ID id) {
        baseService.deleteById(id);
    }


}
