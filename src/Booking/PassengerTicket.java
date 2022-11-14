package Booking;

public class PassengerTicket extends Ticket{

    private double timeLimit = 24;
    
    @Override
    public double getTimeLimit() {
        return timeLimit;
    }

    @Override
    public double getPrice() {
        return price;
    }
    

}
