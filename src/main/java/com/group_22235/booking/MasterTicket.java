package com.group_22235.booking;

public class MasterTicket extends Ticket {
    
    private Boolean master = true;
    private Boolean firstClass = true;
    private double timeLimit = Double.POSITIVE_INFINITY;

    public Boolean getMaster() {
        return master;
    }

    @Override 
    public double getTimeLimit(){
        return timeLimit;
    }

    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public Boolean getFirstClass() {
        return firstClass;
    }

}