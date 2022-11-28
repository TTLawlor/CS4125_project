package com.group_22235.booking;

public class SemiFlex extends AssignTicketType {
    
    private double additionalFee = 0;

    public SemiFlex(ITicketPrice t) {
        super(t);
    }
 
    public double getTimeLimit() {
        return 1;
    }

    public double calcTicketPrice() {
        return super.calcTicketPrice() + additionalFee;
    }

    public Boolean getFirstClass() {
        return false;
    }

}

