package Booking;

public class Flexible extends AssignTicketType {
    
    private double additionalFee = 2;
    private double additionalTime = 23;

    public Flexible(Ticket ticket) {
        super(ticket);
    }
 
    public double getTimeLimit() {
        return super.getTimeLimit() - additionalTime;
    }

    public double getPrice() {
        return ticket.getPrice() + additionalFee;
    }
}
