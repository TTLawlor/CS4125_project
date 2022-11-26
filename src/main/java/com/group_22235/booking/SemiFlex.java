package com.group_22235.booking;

public class SemiFlex extends AssignTicketType {
    
    private double additionalFee = 1;
    private double additionalTime = 24;

    public SemiFlex(Ticket ticket) {
        super(ticket);
    }
 
    public double getTimeLimit() {
        return super.getTimeLimit() - additionalTime;
    }

    public double getPrice() {
        return ticket.getPrice() + additionalFee;
    }

}
