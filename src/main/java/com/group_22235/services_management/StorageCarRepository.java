package com.group_22235.services_management;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.group_22235.generics.IBaseRepository;

@Repository
public interface StorageCarRepository extends IBaseRepository<ACarriage, Long>{
    
    @Query(value = "SELECT * FROM carriage WHERE carriage_type='STORAGE'", nativeQuery = true)
    List<ACarriage> findAll();
}
