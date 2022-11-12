package com.group_22235.services_management;

import java.util.List;

public interface IBaseService<T extends Carriage, ID>{
    public abstract T save(T entity);
    public abstract List<T> findAll(); // you might want a generic Collection if u prefer

    public abstract T findById(ID entityId);
    public abstract T update(T entity);
    public abstract T updateById(T entity, ID entityId);   
    public abstract void delete(T entity);
    public abstract void deleteById(ID entityId);
}
