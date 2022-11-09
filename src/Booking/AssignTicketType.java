package Booking;

public abstract class AssignTicketType implements TicketType {
    protected TicketType ticket;
	
	public AssignTicketType(TicketType t){
		this.ticket=t;
	}
	
	@Override
	public void assign() {
        this.ticket.assign();
	}
}