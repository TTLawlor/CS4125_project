package Booking;

public class FirstClass extends TicketDecorator {
    
    public FirstClass(Ticket ticket) {
        super(ticket);
    }

    private boolean firstClass = true;

    @Override
	public void decorate(){
		super.decorate();
		System.out.print(" Firstclass Ticket");
	}

}
