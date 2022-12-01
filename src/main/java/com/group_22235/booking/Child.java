package com.group_22235.booking;
public class Child implements ITicket{
    
    public double price;

    @Override
    public void setTicketPrice(double typePrice){
          price = 0 + typePrice;
        }

    @Override
    public double getTicketPrice(){
        return price;
        }
  

}
