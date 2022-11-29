package com.group_22235.booking;

public abstract class AssignTicketType implements ITicketPrice {
	private ITicketPrice t;

	public AssignTicketType(ITicketPrice t){
		this.t = t;
	}

	@Override
	public double calcTicketPrice() {
		return t.calcTicketPrice();
	}

	public abstract double getTimeLimit();

	public abstract Boolean getFirstClass();

	
}