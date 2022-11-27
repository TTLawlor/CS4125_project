package com.group_22235.services_management;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalTime;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RouteTimetableTest {
    
    RouteTimetable routeTimetable;

    @Test
    void should_throw_exception_when_parameters_different_sizes(){
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

        Exception thrown = assertThrows(
           Exception.class,
           () -> routeTimetable = new RouteTimetable(route, times));

        String expected_error = "Number of stations and times do not match. Please try again";
        String actual_error = thrown.getMessage();

        assertTrue(actual_error.contains(expected_error));
    }

    @Test
    void should_add_to_routetimetable() throws Exception{
        routeTimetable = new RouteTimetable();

        Station station1 = new Station("Station1", "Kerry");
        LocalTime time1 = LocalTime.of(12, 0);

        routeTimetable.addStop(station1, time1);

        assertEquals(1, routeTimetable.getRouteTimetable().size());
    }

    @Test
    void should_not_add_duplicates_to_routetimetable() throws Exception{
        routeTimetable = new RouteTimetable();

        Station station1 = new Station("Station1", "Kerry");
        LocalTime time1 = LocalTime.of(12, 0);

        routeTimetable.addStop(station1, time1);

        Exception thrown = assertThrows(
           Exception.class,
           () -> routeTimetable.addStop(station1, time1));

        String expected_error = "Stop already exists in this route";
        String actual_error = thrown.getMessage();

        assertTrue(actual_error.contains(expected_error));

    }

    @Test
    void should_check_if_exists_in_remove_from_routetimetable() throws Exception{
        routeTimetable = new RouteTimetable();

        Station station1 = new Station("Station1", "Kerry");
        LocalTime time1 = LocalTime.of(12, 0);
        routeTimetable.addStop(station1, time1);

        Station station2 = new Station("Station2", "Cork");

        Exception thrown = assertThrows(
           Exception.class,
           () -> routeTimetable.removeStop(station2));

        String expected_error = ("Stop doesn't exist in this route");
        String actual_error = thrown.getMessage();

        assertTrue(actual_error.contains(expected_error));
        
    }

    @Test
    void should_remove_from_routetimetable() throws Exception{
        routeTimetable = new RouteTimetable();

        Station station1 = new Station("Station1", "Kerry");
        LocalTime time1 = LocalTime.of(12, 0);
        routeTimetable.addStop(station1, time1);

        routeTimetable.removeStop(station1);

        assertTrue(routeTimetable.getRouteTimetable().isEmpty());
    }

}
