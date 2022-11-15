package com.group_22235.generics;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface IBaseController<T extends ABaseEntity, ID> {

    public abstract T getByID(@PathVariable ID id) throws Exception;

    public abstract List<T> getAll() throws Exception;

    @RequestMapping(method = RequestMethod.POST)
    T post(@RequestBody T t);

    T updateDetails(T entity);

    T updateDetailsByID(ID id);

    public abstract void delete(T entity);

    public abstract void deleteByID(ID id);

}