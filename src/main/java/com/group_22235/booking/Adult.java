package com.group_22235.booking;
public class Adult implements ITicket{
    
  private double price;

      @Override
      public void setTicketPrice(double typePrice){
          price = 5 + typePrice;
      }

      @Override
      public double getTicketPrice(){
           return price;
      }
}
