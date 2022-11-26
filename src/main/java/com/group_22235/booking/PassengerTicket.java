package com.group_22235.booking;

public class PassengerTicket extends Ticket{

    private Boolean firstClass;
    private double timeLimit;
    
    @Override
    public double getTimeLimit() {
        return timeLimit;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public Boolean getFirstClass() {
        return firstClass;
    }
    

}
