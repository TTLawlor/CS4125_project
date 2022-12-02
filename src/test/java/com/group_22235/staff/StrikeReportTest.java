package com.group_22235.staff;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.group_22235.services_management.RouteTimetable;
import com.group_22235.services_management.Station;

@SpringBootTest
class StrikeReportTest{

    @Test
    void should_get_strike_start_date(){

        StrikeReport strike = new StrikeReport(null, null, null, null);
        LocalDate start = LocalDate.of(2022,11,11);
        strike.setStrikeDateStart(start);
        assertEquals(start, strike.getStrikeDateStart());
    }

    @Test
    void should_get_strike_end_date(){

        StrikeReport strike = new StrikeReport(null, null, null, null);
        LocalDate end = LocalDate.of(2022,11,11);
        strike.setStrikeDateEnd(end);
        assertEquals(end, strike.getStrikeDateEnd());
    }

    @Test
    void should_get_affected_routes(){
        StrikeReport strike = new StrikeReport(null, null, null, null);
        
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

        strike.setAffectedRoutes(ttList);
        assertEquals(ttList, strike.getAffectedRoutes());
    }

    @Test
    void should_get_reason(){
        StrikeReport strike = new StrikeReport(null, null, null, null);
        strike.setReason("Holiday Pay Strike");
        assertEquals("Holiday Pay Strike", strike.getReason());
    }
}
