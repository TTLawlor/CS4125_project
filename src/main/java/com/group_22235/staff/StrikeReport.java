package com.group_22235.staff;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.group_22235.generics.ABaseEntity;
import com.group_22235.services_management.RouteTimetable;

@Entity
@Table(name = "STRIKEREPORT")
@AttributeOverride(name = "id", column = @Column(name = "strike_report_id"))
public class StrikeReport extends ABaseEntity {

    @Column
    private LocalDate strikeDateStart;
    @Column
    private LocalDate strikeDateEnd;

    @OneToMany(mappedBy = "strikeReport", cascade=CascadeType.ALL)
    private List<RouteTimetable> affectedRoutes;

    @Column
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
