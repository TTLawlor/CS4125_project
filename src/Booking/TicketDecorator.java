package Booking;

public abstract class TicketDecorator implements Ticket {
    protected Ticket ticket;
	
	public TicketDecorator(Ticket t){
		this.ticket=t;
	}
	
	@Override
	public void decorate() {
        this.ticket.decorate();
	}
}