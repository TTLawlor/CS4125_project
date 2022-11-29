package com.group_22235.booking;

public class FirstClass extends AssignTicketType {

    private double additionalFee = 5;

    public FirstClass(ITicketPrice t) {
        super(t);
    }
 
    public double getTimeLimit() {
        return 24;
    }

    public double calcTicketPrice() {
        return super.calcTicketPrice() + additionalFee;
    }

    @Override
    public Boolean getFirstClass() {
        return true;
    }

}

