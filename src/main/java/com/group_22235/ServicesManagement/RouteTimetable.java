package com.group_22235.ServicesManagement;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class RouteTimetable {
    // This class stores an indiviudal routeTimetable, made up of 1 list of stations(route) and 1 list of times(??)

    private Map<Station, LocalTime> routeTimetable;

    // Constructor takes in list of stations and times, creating a timetable for a route
    public RouteTimetable(ArrayList<Station> stations, ArrayList<LocalTime> times){
        if (stations.size() != times.size()){
            System.out.println("Number of stations and times do not match. Please try again");
            return;
        }
        routeTimetable = new LinkedHashMap<>();

        for (int i = 0; i < stations.size(); i++) {
            Station st = stations.get(i);
            LocalTime t = times.get(i);
            routeTimetable.put(st, t);
            // System.out.println("Loc: " + st.getLocation() + "      Time: " + t.toString());
        }
    }

    public Map<Station, LocalTime> getRouteTimetable() {
        return routeTimetable;
    }

    public void setRouteTimetable(Map<Station, LocalTime> routeTimetable) {
        this.routeTimetable = routeTimetable;
    }

    public void addStop(Station st, LocalTime t) {
        if(checkStopExists(st)) {
            System.out.println("Stop already exists in this route");
            return;
        }
        routeTimetable.put(st, t);
    }

    public void removeStop(Station st) {
        if(!checkStopExists(st)) {
            System.out.println("Stop doesn't exist in this route");
            return;
        }
        routeTimetable.remove(st);
    }

    public void updateStopTime(Station st, LocalTime t) {
        if(!checkStopExists(st)) {
            System.out.println("Stop doesn't exist in this route");
            return;
        }
        routeTimetable.put(st, t);
    }

    private Boolean checkStopExists(Station st){
        for (Map.Entry<Station, LocalTime> entry : routeTimetable.entrySet()) {
            if (entry.getKey() == st)  {
                return true;
            }
        }
        return false;
    }



}
