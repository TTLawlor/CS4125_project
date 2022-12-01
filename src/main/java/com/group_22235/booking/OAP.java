package com.group_22235.booking;

public class OAP implements ITicket{

    private double price;

    @Override
    public void setTicketPrice(double typePrice){
          price = 2.50 + typePrice ;
        }
  
    @Override
        public double getTicketPrice(){
             return price;
        }

}
