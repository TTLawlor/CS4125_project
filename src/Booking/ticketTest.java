package Booking;

public class ticketTest {

	public static void main(String[] args) {
		Ticket semi = new PassengerTicket();
		Ticket t1 = new Flexible(semi);
		semi.setArrStation("Derry");
		t1.setDepStation("Limerick");
		semi.setPrice(10);
		t1.setPrice(5);

		System.out.println(t1.getDepStation());
		System.out.println(t1.getArrStation());
		System.out.println(semi.getPrice() + " " + semi.getTimeLimit());
		System.out.println(t1.getPrice() + " " + t1.getTimeLimit());
		

		System.out.println("\n*****");
		
	}
}