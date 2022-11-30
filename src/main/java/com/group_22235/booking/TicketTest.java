package com.group_22235.booking;

import com.group_22235.services_management.Station;

public class TicketTest {

	public static void main(String[] args) {

	    Station s = new Station("Town", "Letterkenny");
		Station s2 = new Station("Connolly", "Cork");

			TicketFacade a = new TicketFacade(s, s2, 12, 30 , 2022, 3, 20, "FIRST");
		
			System.out.println(s.getLocation() + "-> " + s2.getLocation());
			System.out.println(a.getTicketPrice());
			a.setYAPrice();
			System.out.println("Adult price + price: " + a.getYAPrice());
			System.out.println(a.getTimeLimit());
			System.out.println(a.getFirstClass());
			System.out.println(a.getDate());
			System.out.println(a.getTime());
			
	}

}