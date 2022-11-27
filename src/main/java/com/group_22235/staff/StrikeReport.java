package com.group_22235.staff;

import java.time.LocalDate;
import java.util.List;

import com.group_22235.services_management.RouteTimetable;

public class StrikeReport {
    private LocalDate strikeDateStart;
    private LocalDate strikeDateEnd;
    private List<RouteTimetable> affectedRoutes;
    private String reason;

    public StrikeReport(LocalDate strikeDateStart, LocalDate strikeDateEnd, List<RouteTimetable> affectedRoutes, String reason) {
        this.strikeDateStart = strikeDateStart;
        this.strikeDateEnd = strikeDateEnd;
        this.affectedRoutes = affectedRoutes;
        this.reason = reason;
    }

    public LocalDate getStrikeDateStart() {
        return strikeDateStart;
    }

    public void setStrikeDateStart(LocalDate strikeDateStart) {
        this.strikeDateStart = strikeDateStart;
    }

    public LocalDate getStrikeDateEnd() {
        return strikeDateEnd;
    }

    public void setStrikeDateEnd(LocalDate strikeDateEnd) {
        this.strikeDateEnd = strikeDateEnd;
    }

    public List<RouteTimetable> getAffectedRoutes() {
        return affectedRoutes;
    }

    public void setAffectedRoutes(List<RouteTimetable> affectedRoutes) {
        this.affectedRoutes = affectedRoutes;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    
    
}
