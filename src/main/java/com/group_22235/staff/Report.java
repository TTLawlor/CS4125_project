package com.group_22235.staff;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.group_22235.generics.ABaseEntity;

@Entity
@Table(name = "REPORT")
@AttributeOverride(name = "id", column = @Column(name = "report_id"))
public class Report extends ABaseEntity{
    
    @Column(name = "reporter")
    private String reporter;

    @Column(name = "reportee")
    private String reportee;

    @Column(name = "date_of_report")
    private LocalDate date;

    @Column(name = "time_of_report")
    private LocalTime time;

    @Column(name = "reason")
    private String reason;

    @Column(name = "desription")
    private String description;

    public Report(String reporter, String reportee, String reason, String description) {
        this.reporter = reporter;
        this.reportee = reportee;
        this.reason = reason;
        this.description = description;
        date = LocalDate.now();   
        time = LocalTime.now();   
    }

    public String getReporter() {
        return reporter;
    }

    public void setReporter(String reporter) {
        this.reporter = reporter;
    }

    public String getReportee() {
        return reportee;
    }

    public void setReportee(String reportee) {
        this.reportee = reportee;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
}
