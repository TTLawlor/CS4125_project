package Booking;

public class FirstClass extends TicketDecorator {
    private boolean firstClass = true;

    public FirstClass(Ticket ticket) {
        super(ticket);
    }

    @Override
	public void decorate(){
		super.decorate();
		System.out.print(" Firstclass Ticket");
	}

    public void setFirstClass(Boolean firstClass) {
        this.firstClass = firstClass;
    }

    public Boolean getFirstClass() {
        return firstClass;
    }
}
