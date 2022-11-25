package com.group_22235.generics;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public abstract class ABaseServiceImpl<T extends ABaseEntity, ID>
        implements IBaseService<T, ID>{
    
    private IBaseRepository<T, ID> abstractBaseRepository;
    
    @Autowired
    public ABaseServiceImpl(IBaseRepository<T, ID> abstractBaseRepository) {
        this.abstractBaseRepository = abstractBaseRepository;
    }

    @Override
    public T save(T entity) {
        return (T) abstractBaseRepository.save(entity);
    }

    @Override
    public List<T> findAll() {
        return abstractBaseRepository.findAll();
    }

    @Override
    public T findById(ID entityId) {
        if (entityId == null) {
            return null;
        }
        return abstractBaseRepository.findById(entityId).isPresent() ? 
        abstractBaseRepository.findById(entityId).get(): null;
    }

    @Override
    public T update(T entity) {
        return (T) abstractBaseRepository.save(entity);
    }

    @Override
    public T updateById(ID entityId) {
        Optional<T> optional = abstractBaseRepository.findById(entityId);
        if(optional.isPresent()){
            return (T) abstractBaseRepository.save(optional.get());
        }else{
            return null;
        }
    }

    @Override
    public void delete(T entity) {
        abstractBaseRepository.delete(entity);
    }

    @Override
    public void deleteById(ID entityId) {
        abstractBaseRepository.deleteById(entityId);
    }

}