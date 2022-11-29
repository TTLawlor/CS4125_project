package com.group_22235.services_management;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.group_22235.generics.IBaseRepository;

@Repository
public interface RouteTimetableRepository extends IBaseRepository<RouteTimetable, Long>{
    
    @Query(value = "SELECT * FROM timetable WHERE train_id=?1", nativeQuery = true)
    List<RouteTimetable> findAllByTrainID(Long id);
}
