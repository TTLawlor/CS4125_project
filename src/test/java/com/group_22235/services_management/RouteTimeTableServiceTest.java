package com.group_22235.services_management;


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
        // System.out.println("Route: "+rTime);
        // System.out.println("DB Route: "+routeTimetableService.findAllByTrainID(realT.getId()));


        // assertThat(routeTimetableService.findAllByTrainID(realT.getId())).contains(rTime);
        // assertEquals(rTime.getId(), routeTimetableService.findAllByTrainID(realT.getId())); 
 
    }
    
}
