package com.group_22235.staff;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
    class ReportTest {
    
    @Test
    void should_get_reporter(){
        Report report = new Report("Joe Soap", "Saoirse Ronan", "Broken Window", "Train 6 has a broken window");
        assertEquals("Joe Soap", report.getReporter());
    }

    @Test
    void should_get_reportee(){
        Report report = new Report("Joe Soap", "Saoirse Ronan", "Broken Window", "Train 6 has a broken window");
        assertEquals("Saoirse Ronan", report.getReportee());
    }

    @Test
    void should_get_reason(){
        Report report = new Report("Joe Soap", "Saoirse Ronan", "Broken Window", "Train 6 has a broken window");
        assertEquals("Broken Window", report.getReason());
    }

    @Test
    void should_get_description(){
        Report report = new Report("Joe Soap", "Saoirse Ronan", "Broken Window", "Train 6 has a broken window");
        assertEquals("Train 6 has a broken window", report.getDescription());
    }

    @Test
    void should_set_description(){
        Report report = new Report("Joe Soap", "Saoirse Ronan", "Broken Window", "Train 6 has a broken window");
        report.setDescription("Front window is broken on train 2");
        assertEquals("Front window is broken on train 2", report.getDescription());
    }

    @Test
    void should_set_reason(){
        Report report = new Report("Joe Soap", "Saoirse Ronan", "Broken Window", "Train 6 has a broken window");
        report.setReason("Door broken");
        assertEquals("Door broken", report.getReason());
    }

    @Test
    void should_set_reportee(){
        Report report = new Report("Joe Soap", "Saoirse Ronan", "Broken Window", "Train 6 has a broken window");
        report.setReportee("Clark Kent");
        assertEquals("Clark Kent", report.getReportee());
    }

    @Test
    void should_set_reporter(){
        Report report = new Report("Joe Soap", "Saoirse Ronan", "Broken Window", "Train 6 has a broken window");
        report.setReporter("Bruce Wayne");
        assertEquals("Bruce Wayne", report.getReporter());
    }
}
