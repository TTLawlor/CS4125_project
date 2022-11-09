package Booking;

public class SemiFlexible extends AssignTicketType {
    
    private int timeLimit;

    public SemiFlexible(TicketType ticket) {
        super(ticket);
    }
    
    public void setTimeLimit(int timeLimit) {
        this.timeLimit = timeLimit;
    }

    public int getTimeLimit(){
        return timeLimit;
    }

    @Override
	public void assign(){
		super.assign();
		System.out.print(" SemiFlexiticket");
	}
}
