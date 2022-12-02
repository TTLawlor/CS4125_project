package com.group_22235.staff;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.group_22235.booking.TicketFacade;
import com.group_22235.services_management.RouteTimetable;
import com.group_22235.services_management.Station;
import com.group_22235.services_management.Train;
import com.group_22235.staff.StrikeReport;
import com.group_22235.user.Passenger;

@SpringBootTest
    class AdminTest {
    Admin admin;

    @Test
    void should_call_strike(){
        Admin admin = new Admin("Gerald Rivers", "geraldrivers@hibrail.ie", "Alphonsus");
        // Create a route and constrcut train with it
        

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

        Train train = new Train(ttList);
        // Pass neeeds to book at least one ticket
        Passenger pass = new Passenger("Jon", "test@gmail.com");
        
        LocalTime l = LocalTime.of(10,30);
        LocalTime z = LocalTime.of(12,30);
        LocalDate d = LocalDate.of(2022,11,11);

        TicketFacade a = new TicketFacade(route.get(1), route.get(3), l, z, d, "FIRST");
        pass.bookTicket(a);
        
        StrikeReport strike = new StrikeReport(d, d, ttList,"No money");

        admin.callStrike(strike, train, pass);
    

        assertTrue(train.getRoutes().isEmpty());

        assertTrue(pass.viewAllTickets().isEmpty());
    }
    
}
