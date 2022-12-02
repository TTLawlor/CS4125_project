package com.group_22235.services_management;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import lombok.NoArgsConstructor;

import javax.persistence.AttributeOverride;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.Table;

import com.group_22235.generics.ABaseEntity;

@Entity
@Table(name = "TIMETABLE")
@AttributeOverride(name = "id", column = @Column(name = "route_timetable_id"))
@NoArgsConstructor
public class RouteTimetable extends ABaseEntity {
    // This class stores ONE indiviudal timetable, made up of 1 list of stations(route) and 1 list of times(??)

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "STATION_TIMETABLE", joinColumns = @JoinColumn(name = "ROUTE_TIMETABLE_ID")) 
    @MapKeyJoinColumn(name="STATION_ID")
    @Column(name="LocalTime")
    private Map<Station, LocalTime> timetable = new LinkedHashMap<>();

    // Constructor takes in list of stations and times, creating a timetable for a route
    public RouteTimetable(ArrayList<Station> stations, ArrayList<LocalTime> times) throws IllegalArgumentException {
        if (stations.size() != times.size()){
            throw new IllegalArgumentException("Number of stations and times do not match. Please try again");
        }

        for (int i = 0; i < stations.size(); i++) {
            Station st = stations.get(i);
            LocalTime t = times.get(i);
            timetable.put(st, t);
        }
    }

    public Map<Station, LocalTime> getRouteTimetable() {
        return timetable;
    }

    public void setRouteTimetable(Map<Station, LocalTime> timetable) {
        this.timetable = timetable;
    }

    public void addStop(Station st, LocalTime t) throws Exception {
        if(checkStopExists(st)) {
            throw new Exception("Stop already exists in this route");
        }
        timetable.put(st, t);
    }

    public void removeStop(Station st) throws Exception {
        if(!checkStopExists(st)) {
            throw new Exception("Stop doesn't exist in this route");
        }
        timetable.remove(st);
    }

    public void updateStopTime(Station st, LocalTime t) throws Exception {
        if(!checkStopExists(st)) {
            throw new Exception("Stop doesn't exists in this route");
        }
        timetable.put(st, t);
    }

    private Boolean checkStopExists(Station st){
        for (Map.Entry<Station, LocalTime> entry : timetable.entrySet()) {
            if (entry.getKey() == st)  {
                return true;
            }
        }
        return false;
    }

    public LocalTime getStationTime(Station station){
        for (Map.Entry<Station, LocalTime> entry : timetable.entrySet()) {
            if (entry.getKey() == station)  {
                return entry.getValue();
            }
        }
        return null;
    }

    @Override
    public String toString() {
        String result = "RouteTimetable: \n";
        List<Entry<Station, LocalTime>> list = new ArrayList<>(timetable.entrySet());
        list.sort(Entry.comparingByValue());
        StringBuilder bld = new StringBuilder();
        bld.append(result);
        for (Map.Entry<Station, LocalTime> entry : list) {
            bld.append("Loc: " + entry.getKey() + ", Time: " + entry.getValue() + "\n");
        }
        return bld.toString();
    }

}
