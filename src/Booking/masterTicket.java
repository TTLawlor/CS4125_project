package Booking;

public class MasterTicket extends Ticket {
    
    private Boolean master = true;
    private double timeLimit = Double.POSITIVE_INFINITY;

    public Boolean getMaster() {
        return master;
    }

    @Override 
    public double getTimeLimit(){
        return timeLimit;
    }

    @Override
    public double getPrice() {
        return 0;
    }
}