package com.group_22235.booking;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.group_22235.generics.ABaseEntity;
import com.group_22235.services_management.Station;

@Entity
@Table(name = "TICKET")
@AttributeOverride(name = "id", column = @Column(name = "ticket_id"))
public class TicketFacade extends ABaseEntity{
    @Transient
    private Adult adult;
    @Transient
    private Child child;
    @Transient
    private OAP oap;
    @Transient
    private YoungAdult youngAdult;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "arr_station_id")
    private Station arrStation;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "dep_station_id")
    private Station depStation;

    @Column
    private String ticketType; 

    @Column
    private String date;
    
    @Column
    private LocalTime time;

    @Column
    protected double typePrice;

    @Column
    protected double price;

    @Column
    protected double timeLimit;

    @Column
    protected Boolean firstClass;

    public TicketFacade(Station depStation, Station arrStation, LocalTime time, LocalDate date,
    String ticketType){

        this.depStation = depStation;
        this.arrStation = arrStation;

        this.time = time;

        this.date = date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT));
        
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
        price += adult.getTicketPrice();
    }

    public double getChildPrice(){
       return child.getTicketPrice();
    }

    public void setChildPrice(){
        child.setTicketPrice(typePrice);
        price += child.getTicketPrice();
    }

    public double getOAPPrice(){
        return oap.getTicketPrice();
    }

    public void setOAPPrice(){
        oap.setTicketPrice(typePrice);
        price += oap.getTicketPrice();
    }

    public double getYAPrice(){
        return youngAdult.getTicketPrice();
    }

    public void setYAPrice(){
        youngAdult.setTicketPrice(typePrice);
        price += youngAdult.getTicketPrice();
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
            this.ticketType = ticketType;
            this.typePrice = 0;
            this.timeLimit = 1;
            this.firstClass = false;
          break;
        case "FLEX":
            this.ticketType = ticketType;
            this.typePrice = 2;
            this.timeLimit = 24;
            this.firstClass = false;
          break;
        case "FIRST":
            this.ticketType = ticketType;
            this.typePrice = 5;
            this.timeLimit = 23;
            this.firstClass = true;
          break;
          case "MASTER":
            this.ticketType = ticketType;
            this.typePrice = 0;
            this.timeLimit = 0;
            this.firstClass = true;
          break;
          default:
          throw new IllegalArgumentException("Invalid Ticket Type Given");
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
