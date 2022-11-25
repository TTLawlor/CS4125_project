package com.group_22235.services_management;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TrainServiceTest {
    
    @Autowired
    private TrainService trainService;

    @Autowired
	private CarriageFactoryService cFactoryService;

    @Autowired
    private PassengerCarService passengerCarService;

    @Autowired 
    RouteTimetableService routeTimetableService;

    @Autowired 
    StationService stationService;

    @Test
    void testPassengerCarriagesFindAll() throws Exception {
        Train train1 = new Train();
        train1.assignCar(cFactoryService.createCarriage("DINING"));
        train1.assignCar(cFactoryService.createCarriage("PASSENGER"));
        train1.assignCar(cFactoryService.createCarriage("PASSENGER"));
        trainService.save(train1);
        assertNotNull(passengerCarService.findAll());
    }

    @Test
    void testTrainFindByID(){
        Train train = new Train();
        trainService.save(train);
        assertNotNull(trainService.findById(train.getId()));
    }
    
    @Test
    void testUpdateStrikeRemoveMapping(){
        // Creating timetable

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
        times.add(LocalTime.of(2, 0));
        times.add(LocalTime.of(3, 0));
        times.add(LocalTime.of(4, 0));
        times.add(LocalTime.of(5, 0));
        times.add(LocalTime.of(8, 0));

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

        assertNotNull(routeTimetableService.findById(rTime.getId()));
        trainService.updateStrike(realT);
        assertNull(routeTimetableService.findById(rTime.getId()));
    }

}
