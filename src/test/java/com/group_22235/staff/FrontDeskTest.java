package com.group_22235.staff;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;

import com.group_22235.services_management.Station;
import com.group_22235.staff.StrikeReport;

@SpringBootTest
public class FrontDeskTest {
    
    Station station = new Station("Station 1", "Letterkenny");

    @Test
    void should_get_station(){
    FrontDesk desk = new FrontDesk(null, null, null, null);
    desk.setStation(station);
    assertEquals( station ,desk.getStation());
    }

    // @Test
    // void should_make_report(){
        
    // }
}
