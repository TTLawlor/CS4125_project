package com.group_22235.booking;

public abstract class AssignPassengerType implements ITicketPrice {
    private ITicketPrice t;

    public AssignPassengerType(ITicketPrice t){
		this.t = t;
	}

    @Override
	public double calcTicketPrice() {
		return t.calcTicketPrice();
	}
}
