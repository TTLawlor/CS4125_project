package com.group_22235.ServicesManagement;

import java.time.LocalTime;
import java.util.ArrayList;

public class TrainTest {

    public void trainTest(){
        // Creating timetable

        // Creating stations list(route)
        ArrayList<Station> route = new ArrayList<>();
        route.add(new Station("Kerry"));
        route.add(new Station("Cork"));
        route.add(new Station("Limerick"));
        route.add(new Station("Tipp"));
        route.add(new Station("Dub"));

        // Creating times list
        ArrayList<LocalTime> times = new ArrayList<>();
        times.add(LocalTime.of(2, 0));
        times.add(LocalTime.of(3, 0));
        times.add(LocalTime.of(4, 0));
        times.add(LocalTime.of(5, 0));
        times.add(LocalTime.of(8, 0));
        

        ArrayList<LocalTime> times2 = new ArrayList<>();
        times2.add(LocalTime.of(12, 0));
        times2.add(LocalTime.of(13, 0));
        times2.add(LocalTime.of(14, 0));
        times2.add(LocalTime.of(15, 0));
        times2.add(LocalTime.of(18, 0));

        RouteTimetable rTime = new RouteTimetable(route, times2);

        ArrayList<RouteTimetable> ttList = new ArrayList<>();
        ttList.add(rTime);

        System.out.println("c");

        Train realT = new Train(ttList);
    }
}
