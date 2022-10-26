package Booking;

public class ticketTest {

	public static void main(String[] args) {
		Ticket t1 = new Flexible(new BasicTicket());
		t1.decorate();
		System.out.println("\n*****");
		
		Ticket t2 = new FirstClass(new BasicTicket());
		t2.decorate();
	}

}