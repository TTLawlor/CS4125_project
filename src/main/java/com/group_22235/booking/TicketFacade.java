package com.group_22235.booking;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import com.group_22235.services_management.Station;

public class TicketFacade {
    private Adult adult;
    private Child child;
    private OAP oap;
    private YoungAdult youngAdult;

    private Station depStation, arrStation;
    private String ticketType, date; 
    private LocalTime time;

    protected double typePrice, price, timeLimit;
    protected Boolean firstClass;

    public TicketFacade(Station depStation, Station arrStation, int hour, int mins, int year, int month, int day,
    String ticketType){

        this.depStation = depStation;
        this.arrStation = arrStation;

        LocalTime t = LocalTime.of(hour, mins);
        this.time = t;

        LocalDate d = LocalDate.of(year, month, day);
        this.date = d.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT));
        
        setTicketType(ticketType);

        adult = new Adult();
        child = new Child();
        oap = new OAP();
        youngAdult = new YoungAdult();
    }

    public double getAdultPrice(){
        return adult.getTicketPrice();
    }

    public void setAdultPrice(){
        adult.setTicketPrice(typePrice);
    }

    public double getChildPrice(){
       return child.getTicketPrice();
    }

    public void setChildPrice(){
        child.setTicketPrice(typePrice);
    }

    public double getOAPPrice(){
        return oap.getTicketPrice();
    }

    public void setOAPPrice(){
        oap.setTicketPrice(typePrice);
    }

    public double getYAPrice(){
        return youngAdult.getTicketPrice();
    }

    public void setYAPrice(){
        youngAdult.setTicketPrice(typePrice);
    }

// Base ticket setters aand getters //

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

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

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
            this.typePrice = 0;
            this.timeLimit = 1;
            this.firstClass = false;
          break;
        case "FLEX":
            this.typePrice = 2;
            this.timeLimit = 24;
            this.firstClass = false;
          break;
        case "FIRST":
            this.typePrice = 5;
            this.timeLimit = 23;
            this.firstClass = true;
          break;
          case "MASTER":
            this.typePrice = 0;
            this.timeLimit = 0;
            this.firstClass = true;
          break;
      }
    }

    public double getTicketPrice(){
        return typePrice;
    }
    
    public void setTicketPrice(double typePrice){
        this.typePrice = typePrice;
    }

    public double getTimeLimit() {
        return timeLimit;
    }

    public Boolean getFirstClass() {
        return firstClass;
    }
    

}
