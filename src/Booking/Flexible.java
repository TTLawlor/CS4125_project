package Booking;

public class Flexible extends TicketDecorator {
    
    public Flexible(Ticket ticket) {
        super(ticket);
    }
    
    @Override
	public void decorate(){
		super.decorate();
		System.out.print(" Flexiticket");
	}
}
