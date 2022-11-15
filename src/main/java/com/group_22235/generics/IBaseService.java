package com.group_22235.generics;

import java.util.List;

public interface IBaseService<T extends ABaseEntity, ID>{
    public abstract T save(T entity);
    public abstract List<T> findAll(); // you might want a generic Collection if u prefer

    public abstract T findById(ID entityId);
    public abstract T update(T entity);
    public abstract T updateById(ID entityId);   
    public abstract void delete(T entity);
    public abstract void deleteById(ID entityId);
}
