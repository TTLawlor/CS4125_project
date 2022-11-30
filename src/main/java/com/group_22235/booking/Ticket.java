package com.group_22235.booking;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import com.group_22235.services_management.Station;

public abstract class Ticket  {

    private Station depStation, arrStation; // Will need changing to Station obj
    private String ticketType, date; 
    protected double price, timeLimit;
    
    protected Boolean firstClass;


    public Ticket(Station depStation, Station arrStation, String passType, String time,
     int day, int month, int year, String ticketType) {
        this.depStation = depStation;
        this.arrStation = arrStation;

        LocalDate d = LocalDate.of(day, month, year);
        this.date = d.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT));
        
        setTicketType(ticketType);
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

    // public void setPassType(String passType){
    //     this.passType = passType;
    // }

    // public String getPassType(){
    //     return passType;
    // }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        
    switch(ticketType) {
        case "SEMI":
            this.price = 0;
            this.timeLimit = 1;
            this.firstClass = false;
          break;
        case "FLEX":
            this.price = 2;
            this.timeLimit = 24;
            this.firstClass = false;
          break;
        case "FIRST":
            this.price = 5;
            this.timeLimit = 23;
            this.firstClass = true;
          break;
          case "MASTER":
            this.price = 0;
            this.timeLimit = 0;
            this.firstClass = true;
          break;
      }
    }

    public double getTicketPrice(){
        return price;
    }
    
    public void setTicketPrice(double price){
        this.price = price;
    }

    public double getTimeLimit() {
        return timeLimit;
    }

    public Boolean getFirstClass() {
        return firstClass;
    }
    
}    
