package com.group_22235.services_management;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalTime;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TrainTest {
    
    Train train;

    @Autowired
    CarriageFactoryService carriageFactoryService;

    @Test
    void should_create_instance_no_args(){
        train = new Train();
        assertNotNull(train);
    }

    @Test
    void should_create_instance_from_cars_and_timetable(){
        ArrayList<ACarriage> carriages = new ArrayList<>();

        carriages.add(carriageFactoryService.createCarriage("PASSENGER"));
        carriages.add(carriageFactoryService.createCarriage("PASSENGER"));        
        carriages.add(carriageFactoryService.createCarriage("PASSENGER"));
        carriages.add(carriageFactoryService.createCarriage("STORAGE"));

        ArrayList<RouteTimetable> timetables = new ArrayList<>();
        ArrayList<Station> route1 = new ArrayList<>();
        ArrayList<Station> route2 = new ArrayList<>();
        route1.add(new Station("Station1", "Kerry"));
        route1.add(new Station("Station2", "Cork"));
        route2.add(new Station("Station3", "Limerick"));
        route2.add(new Station("Station4", "Tipp"));

        // Creating times list
        ArrayList<LocalTime> times = new ArrayList<>();
        times.add(LocalTime.of(2, 0));
        times.add(LocalTime.of(3, 0));
        times.add(LocalTime.of(4, 0));

        RouteTimetable routeTimetable = new RouteTimetable(route1, times);
        RouteTimetable routeTimetable2 = new RouteTimetable(route2, times);

        timetables.add(routeTimetable);
        timetables.add(routeTimetable2);

        train = new Train(carriages, timetables);
        assertNotNull(train);
    }

    @Test
    void should_add_carriage(){
        // Default train is 7 passeneger cars and a storage car
        train = new Train();
        train.assignCar(carriageFactoryService.createCarriage("PASSENGER"));
        assertEquals(9, train.getNumCarriages());
    }

    @Test
    void should_add_routes(){
        // Default train is 7 passeneger cars and a storage car
        train = new Train();

        ArrayList<RouteTimetable> timetables = new ArrayList<>();
        ArrayList<Station> route1 = new ArrayList<>();
        ArrayList<Station> route2 = new ArrayList<>();
        route1.add(new Station("Station1", "Kerry"));
        route1.add(new Station("Station2", "Cork"));
        route2.add(new Station("Station3", "Limerick"));
        route2.add(new Station("Station4", "Tipp"));

        // Creating times list
        ArrayList<LocalTime> times = new ArrayList<>();
        times.add(LocalTime.of(2, 0));
        times.add(LocalTime.of(3, 0));
        times.add(LocalTime.of(4, 0));

        RouteTimetable routeTimetable = new RouteTimetable(route1, times);
        RouteTimetable routeTimetable2 = new RouteTimetable(route2, times);

        timetables.add(routeTimetable);
        timetables.add(routeTimetable2);

        train.setRoutes(timetables);
        assertNotNull(train.getRoutes());
    }

    @Test
    void should_list_carriages(){
        // Default train is 7 passeneger cars and a storage car
        train = new Train();
        ACarriage diningCarriage = carriageFactoryService.createCarriage("DINING");
        train.assignCar(diningCarriage);
        assertTrue(train.listCars().contains(diningCarriage));
    }

    @Test
    void should_not_add_over_max_carriage(){
        // maxCarCount = 10
        // Default train is 7 passeneger cars and a storage car
        train = new Train();
        train.assignCar(carriageFactoryService.createCarriage("PASSENGER"));
        train.assignCar(carriageFactoryService.createCarriage("PASSENGER"));
        train.assignCar(carriageFactoryService.createCarriage("PASSENGER"));
        assertEquals(10, train.getNumCarriages());
    }

    @Test
    void should_not_add_over_one_dining_carriage(){
        // Default train is 7 passeneger cars and a storage car
        train = new Train();
        train.assignCar(carriageFactoryService.createCarriage("DINING"));
        train.assignCar(carriageFactoryService.createCarriage("DINING"));
        assertEquals(9, train.getNumCarriages());
    }

    @Test
    void should_not_add_over_one_storage_carriage(){
        CarriageFactoryService cFactoryService = new CarriageFactoryService();
        ArrayList<ACarriage> carriages = new ArrayList<>();

        carriages.add(cFactoryService.createCarriage("PASSENGER"));

        ArrayList<RouteTimetable> timetables = new ArrayList<>();
        ArrayList<Station> route1 = new ArrayList<>();
        route1.add(new Station("Station1", "Kerry"));

        // Creating times list
        ArrayList<LocalTime> times = new ArrayList<>();
        times.add(LocalTime.of(2, 0));

        RouteTimetable routeTimetable = new RouteTimetable(route1, times);
        RouteTimetable routeTimetable2 = new RouteTimetable(route1, times);

        timetables.add(routeTimetable);
        timetables.add(routeTimetable2);

        train = new Train(carriages, timetables);

        train.assignCar(carriageFactoryService.createCarriage("STORAGE"));
        train.assignCar(carriageFactoryService.createCarriage("STORAGE"));
        assertEquals(2, train.getNumCarriages());
    }

    @Test
    void should_check_train_doesnt_have_storage_car(){
        CarriageFactoryService cFactoryService = new CarriageFactoryService();
        ArrayList<ACarriage> carriages = new ArrayList<>();

        carriages.add(cFactoryService.createCarriage("PASSENGER"));

        ArrayList<RouteTimetable> timetables = new ArrayList<>();
        ArrayList<Station> route1 = new ArrayList<>();
        route1.add(new Station("Station1", "Kerry"));

        // Creating times list
        ArrayList<LocalTime> times = new ArrayList<>();
        times.add(LocalTime.of(2, 0));

        RouteTimetable routeTimetable = new RouteTimetable(route1, times);
        RouteTimetable routeTimetable2 = new RouteTimetable(route1, times);

        timetables.add(routeTimetable);
        timetables.add(routeTimetable2);

        train = new Train(carriages, timetables);
        ACarriage storageCarriage = carriageFactoryService.createCarriage("STORAGE");

        train.assignCar(storageCarriage);
        assertNotNull(train.listCars().contains(storageCarriage));
    }

    @Test
    void should_remove_all_routes_when_strike(){
        // Creating timetable
        // Creating stations list(route)
        ArrayList<Station> route = new ArrayList<>();
        route.add(new Station("Station1", "Kerry"));
        route.add(new Station("Station2", "Cork"));
        route.add(new Station("Station3", "Limerick"));
        route.add(new Station("Station4", "Tipp"));
        route.add(new Station("Station5", "Dub"));


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

        train = new Train(ttList);
        train.updateStrike();
        assertTrue(train.getRoutes().isEmpty());
    }
}
