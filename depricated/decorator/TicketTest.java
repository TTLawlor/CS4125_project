package com.group_22235.booking;

import com.group_22235.services_management.Station;

public class TicketTest {

	public static void main(String[] args) {

	    Station s = new Station("Town", "Letterkenny");
		Station s2 = new Station("Connolly", "Cork");

		Ticket v = new Ticket(s , s2 , "YA", "1:00",
		2022, 11, 28);
		
		ITicketPrice d = new FirstClass( new Adult(v));

		System.out.println(s.getLocation() + "-> " + s2.getLocation());
		System.out.println(d.calcTicketPrice());
		System.out.println(d.getTimeLimit());
		System.out.println(d.getFirstClass());
		System.out.println(v.getDate());

		System.out.println("--------------");
	}

}