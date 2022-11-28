package com.group_22235.booking;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import com.group_22235.services_management.Station;

public class Ticket implements ITicketPrice {

    private Station depStation, arrStation; // Will need changing to Station obj
    private String passType, date;
    protected double price, timeLimit;
    protected Boolean firstClass;


    public Ticket(Station depStation, Station arrStation, String passType, String time,
     int day, int month, int year) {
        this.depStation = depStation;
        this.arrStation = arrStation;
        this.passType = passType;

        LocalDate d = LocalDate.of(day, month, year);

        this.date = d.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT));
        
    }

    public void setDepStation(Station depStation){
        this.depStation = depStation;
    }

    public Station getDepStation(){
        return depStation;
    }

    public void setArrStation(Station arrStation){
        this.arrStation = arrStation;
    }

    public Station getArrStation(){
        return arrStation;
    }

    public void setPassType(String passType){
        this.passType = passType;
    }

    public String getPassType(){
        return passType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double calcTicketPrice(){
        return price;
    }
    
    public double getTimeLimit() {
        return timeLimit;
    }

    public Boolean getFirstClass() {
        return firstClass;
    }
    
}    
