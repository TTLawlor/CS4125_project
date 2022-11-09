package Booking;

public class ticketTest {

	public static void main(String[] args) {
		TicketType t1 = new Flexible(new BasicTicket());
		//t1.setArrStation("Derry");
		t1.assign();
		System.out.println("\n*****");
		
		TicketType t2 = new FirstClass(new BasicTicket());
		t2.assign();
	}

}