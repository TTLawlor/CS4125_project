package com.group_22235.booking;

public class Child extends AssignPassengerType {
    
    private double additionalFee = 0;

    public Child(ITicketPrice t){
        super(t);
    }

    public double getTimeLimit() {
        return 0;
    }

    public double calcTicketPrice() {
        return super.calcTicketPrice() + additionalFee;
    }

    public Boolean getFirstClass() {
        return false;
    }

}
