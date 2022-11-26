package com.group_22235.booking;

public abstract class AssignTicketType extends Ticket {
    protected Ticket ticket;
	
	public AssignTicketType(Ticket t){
		this.ticket=t;
	}
	
	public double getTimeLimit() {
        return ticket.getTimeLimit();
	}

	public double getPrice() {
        return ticket.getPrice();
	}

	public Boolean getFirstClass() {
        return ticket.getFirstClass();
    }
}