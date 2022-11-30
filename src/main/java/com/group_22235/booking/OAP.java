package com.group_22235.booking;

import com.group_22235.services_management.Station;

public class OAP extends Ticket{
    

    public OAP(Station depStation, Station arrStation, String passType, String time, int day, int month, int year,
            String ticketType) {
        super(depStation, arrStation, passType, time, day, month, year, ticketType);
    }

    @Override
    public void setTicketPrice(double price){
          price = 2.50 ;
        }
  

}
