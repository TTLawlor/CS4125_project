package com.group_22235.services_management;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.group_22235.generics.IBaseRepository;

@Repository
public interface RouteTimetableRepository extends IBaseRepository<RouteTimetable, Long>{
    
    @Query(value = "SELECT * FROM timetable WHERE train_id=?1", nativeQuery = true)
    List<RouteTimetable> findAllByTrainID(Long id);

    @Query(value = "SELECT * FROM (SELECT * from station_timetable WHERE station_id=?1) AS t1 JOIN (SELECT * FROM station_timetable WHERE station_id=?2) AS t2 ON t1.route_timetable_id=t2.route_timetable_id WHERE t1.local_time < t2.local_time", nativeQuery = true)
    List<RouteTimetable> findByStationIDs(Long s1_id, Long s2_id);
}
