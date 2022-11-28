package com.group_22235.booking;

public class Adult extends AssignPassengerType {
    
    private double additionalFee = 5;

    public Adult(ITicketPrice t){
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
