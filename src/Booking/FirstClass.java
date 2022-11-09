package Booking;

public class FirstClass extends AssignTicketType {
    private boolean firstClass = true;
    private int timeLimit;
    
    public FirstClass(TicketType ticket) {
        super(ticket);
    }

    @Override
	public void assign(){
		super.assign();
		System.out.print("First Class = " + getFirstClass());
	}

    public void setFirstClass(Boolean firstClass) {
        this.firstClass = firstClass;
    }

    public Boolean getFirstClass() {
        return firstClass;
    }

    public void setTimeLimit(int timeLimit) {
        this.timeLimit = timeLimit;
    }

    public int getTimeLimit(){
        return timeLimit;
    }
}
