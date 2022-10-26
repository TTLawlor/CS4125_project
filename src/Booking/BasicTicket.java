package Booking;

public class BasicTicket implements Ticket {

    @Override
    public void decorate() {
        System.out.println("Ticket");
    }
}