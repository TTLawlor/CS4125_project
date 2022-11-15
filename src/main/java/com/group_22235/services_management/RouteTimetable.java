package com.group_22235.services_management;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.group_22235.generics.ABaseEntity;

@Entity
@Table(name = "ROUTE")
@AttributeOverride(name = "id", column = @Column(name = "route_timetable_id"))
public class RouteTimetable extends ABaseEntity {
    // This class stores an indiviudal routeTimetable, made up of 1 list of stations(route) and 1 list of times(??)

    @Transient
    private Map<Station, LocalTime> routeTimetable;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name="STATION_TIMETABLE",
        joinColumns=
            @JoinColumn(name="TIMETABLE_ID", referencedColumnName="ROUTE_TIMETABLE_ID"),
        inverseJoinColumns=
            @JoinColumn(name="STATION_ID", referencedColumnName="STATION_ID")
    )
    private Set<Station> stations = routeTimetable.keySet();

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
