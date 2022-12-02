package com.group_22235.booking;

public class YoungAdult extends AssignPassengerType {
    
    private double additionalFee = 2.50;

    public YoungAdult(ITicketPrice t){
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
