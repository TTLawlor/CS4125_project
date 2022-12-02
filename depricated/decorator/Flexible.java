package com.group_22235.booking;

public class Flexible extends AssignTicketType {
    
    private double additionalFee = 2;


    public Flexible(ITicketPrice t) {
        super(t);
    }
 
    public double getTimeLimit() {
        return 24;
    }

    public double calcTicketPrice() {
        return super.calcTicketPrice() + additionalFee;
    }

    public Boolean getFirstClass() {
        return false;
    }

}
