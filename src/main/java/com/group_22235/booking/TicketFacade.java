package com.group_22235.booking;

import com.group_22235.services_management.Station;

public class TicketFacade {
    private Ticket adult;
    private Ticket child;
    private Ticket oap;
    private Ticket youngAdult;

    public TicketFacade(Station depStation, Station arrStation, String passType, String time, int day, int month, int year,
    String ticketType){
        adult = new Adult(depStation, arrStation, passType, time, day, month, year, ticketType);
        child = new Child(depStation, arrStation, passType, time, day, month, year, ticketType);
        oap = new OAP(depStation, arrStation, passType,time, day, month, year, ticketType);
        youngAdult = new YoungAdult(depStation, arrStation, passType, time, day, month, year, ticketType);
    }

    public void getAdultPrice(){
        adult.getTicketPrice();
    }

    public void getChildPrice(){
        child.getTicketPrice();
    }

    public void getOAPPrice(){
        oap.getTicketPrice();
    }

    public void getYAPrice(){
        youngAdult.getTicketPrice();
    }

}
