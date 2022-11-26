package com.group_22235.booking;

public class TicketTest {

	public static void main(String[] args) {
		Ticket semi = new PassengerTicket();
		Ticket demi = new PassengerTicket();
		
		Ticket t1 = new Flexible(semi);
		Ticket t2 = new FirstClass(demi);
		
		t1.setArrStation("Derry");
		t1.setDepStation("Limerick");
		semi.setPrice(10);

		t2.setArrStation("Donegal");
		t2.setDepStation("Cork");
		t2.setPrice(20);

		System.out.println(t1.getDepStation());
		System.out.println(t1.getArrStation());
		System.out.println(semi.getPrice() + " " + semi.getTimeLimit());
		System.out.println(t1.getPrice() + " " + t1.getTimeLimit());
		System.out.println("Is first class: " + t1.getFirstClass());
		

		System.out.println("\n*****");
		
		System.out.println(t2.getDepStation());
		System.out.println(t2.getArrStation());
		System.out.println(t2.getPrice() + " " + t2.getTimeLimit());
		System.out.println("Is first class: " + t2.getFirstClass());

	}
}