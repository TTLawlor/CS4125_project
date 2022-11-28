package com.group_22235.booking;

public class MasterTicket extends AssignTicketType {


    private Boolean master = true;
    private Boolean firstClass = true;
    private double timeLimit = Double.POSITIVE_INFINITY;

        
    public MasterTicket(ITicketPrice t) {
        super(t);
    }

    public Boolean getMaster() {
        return master;
    }

    @Override 
    public double getTimeLimit(){
        return timeLimit;
    }

    @Override
    public double calcTicketPrice() {
        return 0;
    }

    @Override
    public Boolean getFirstClass() {
        return firstClass;
    }

}