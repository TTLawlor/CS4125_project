package com.group_22235.booking;

public class FirstClass extends AssignTicketType {
    private boolean firstClass = true;
    private double additionalFee = 5;
    private double additionalTime = 23;


    public FirstClass(Ticket ticket) {
        super(ticket);
    }


    public double getAdditionalFee() {
        return additionalFee;
    }

    public Boolean getFirstClass() {
        return firstClass;
    }

    public double getTimeLimit() {
        return super.getTimeLimit() - additionalTime;
    }

    public double getPrice(){
        return ticket.getPrice() + additionalFee;
    }

}
