package com.group_22235.booking;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.group_22235.services_management.RouteTimetable;
import com.group_22235.services_management.Station;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class TicketDto {
    // @NotNull(message = "Please choose a passenger type")
    private String passType;

    @NotNull(message = "Please choose an arrival station")
    private Station arrStation;

    @NotNull(message = "Please choose an arrival station")
    private Station depStation;

    @NotEmpty(message = "Please choose a ticket type")
    private String ticketType;
    
    @NotNull(message = "Please choose a date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date; 

    // @NotEmpty(message = "Please choose a time")
    private LocalTime time;

    protected double typePrice; 

    protected double price;

    protected double timeLimit;

    private String route;

    public Station getArrStation() {
        return arrStation;
    }

    public void setArrStation(Station arrStation) {
        this.arrStation = arrStation;
    }

    public Station getDepStation() {
        return depStation;
    }

    public void setDepStation(Station depStation) {
        this.depStation = depStation;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public double getTypePrice() {
        return typePrice;
    }

    public void setTypePrice(double typePrice) {
        this.typePrice = typePrice;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(double timeLimit) {
        this.timeLimit = timeLimit;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getPassType() {
        return passType;
    }

    public void setPassType(String passType) {
        this.passType = passType;
    }

    

}
