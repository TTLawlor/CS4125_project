package com.group_22235.services_management;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalTime;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RouteTimeTableServiceTest {
    
    @Autowired
    private TrainService trainService;

    @Autowired 
    RouteTimetableService routeTimetableService;

    @Autowired 
    StationService stationService;
    
    @Test
    void should_find_all_route_timetables_by_train_id(){
        // Creating stations list(route)
        ArrayList<Station> route = new ArrayList<>();
        Station station1 = new Station("Station1", "Kerry");
        Station station2 = new Station("Station2", "Cork");
        Station station3 = new Station("Station3", "Limerick");
        Station station4 = new Station("Station4", "Tipp");
        Station station5 = new Station("Station5", "Dub");

        route.add(station1);
        route.add(station2);
        route.add(station3);
        route.add(station4);
        route.add(station5);

        // Creating times list
        ArrayList<LocalTime> times = new ArrayList<>();
        times.add(LocalTime.of(12, 0));
        times.add(LocalTime.of(13, 0));
        times.add(LocalTime.of(14, 0));
        times.add(LocalTime.of(15, 0));
        times.add(LocalTime.of(18, 0));
 
        RouteTimetable rTime = new RouteTimetable(route, times);

        ArrayList<RouteTimetable> ttList = new ArrayList<>();
        ttList.add(rTime);

        stationService.save(station1);
        stationService.save(station2);
        stationService.save(station3);
        stationService.save(station4);
        stationService.save(station5);
        routeTimetableService.save(rTime);

        Train realT = new Train(ttList);
        trainService.save(realT);

        assertEquals(1, routeTimetableService.findAllByTrainID(realT.getId()).size()); 
 
    }

    @Test
    void should_update_routetimetable() {
        // Creating stations list(route)
        ArrayList<Station> route = new ArrayList<>();
        Station station1 = new Station("Station1", "Kerry");
        Station station2 = new Station("Station2", "Cork");

        route.add(station1);
        route.add(station2);

        // Creating times list
        ArrayList<LocalTime> times = new ArrayList<>();
        times.add(LocalTime.of(12, 0));
        times.add(LocalTime.of(13, 0));
 
        RouteTimetable rTime = new RouteTimetable(route, times);

        ArrayList<RouteTimetable> ttList = new ArrayList<>();
        ttList.add(rTime);

        stationService.save(station1);
        stationService.save(station2);
        routeTimetableService.save(rTime);

        Station station3 = new Station("Station3", "Dublin");
        stationService.save(station3);

        rTime.addStop(station3, LocalTime.of(14, 0));
        routeTimetableService.update(rTime);

        RouteTimetable rTimetable = routeTimetableService.findById(rTime.getId());

        assertEquals(3, rTimetable.getRouteTimetable().size());
    }

    @Test
    void should_update_routetimetable_by_id() {
         // Creating stations list(route)
         ArrayList<Station> route = new ArrayList<>();
         Station station1 = new Station("Station1", "Kerry");
         Station station2 = new Station("Station2", "Cork");
 
         route.add(station1);
         route.add(station2);
 
         // Creating times list
         ArrayList<LocalTime> times = new ArrayList<>();
         times.add(LocalTime.of(12, 0));
         times.add(LocalTime.of(13, 0));
  
         RouteTimetable rTime = new RouteTimetable(route, times);
 
         ArrayList<RouteTimetable> ttList = new ArrayList<>();
         ttList.add(rTime);
 
         stationService.save(station1);
         stationService.save(station2);
         routeTimetableService.save(rTime);
 
         Station station3 = new Station("Station3", "Dublin");
         stationService.save(station3);
 
         rTime.addStop(station3, LocalTime.of(14, 0));
         routeTimetableService.updateById(rTime.getId());
 
         RouteTimetable rTimetable = routeTimetableService.findById(rTime.getId());
 
         assertEquals(2, rTimetable.getRouteTimetable().size());
    }

    @Test
    void should_delete_routetimetable() {
        // Creating stations list(route)
        ArrayList<Station> route = new ArrayList<>();
        Station station1 = new Station("Station1", "Kerry");
        Station station2 = new Station("Station2", "Cork");

        route.add(station1);
        route.add(station2);

        // Creating times list
        ArrayList<LocalTime> times = new ArrayList<>();
        times.add(LocalTime.of(12, 0));
        times.add(LocalTime.of(13, 0));

        RouteTimetable rTime = new RouteTimetable(route, times);

        ArrayList<RouteTimetable> ttList = new ArrayList<>();
        ttList.add(rTime);

        stationService.save(station1);
        stationService.save(station2);
        routeTimetableService.save(rTime);
        routeTimetableService.delete(rTime);

        assertNull(routeTimetableService.findById(rTime.getId()));
    }
    
}
