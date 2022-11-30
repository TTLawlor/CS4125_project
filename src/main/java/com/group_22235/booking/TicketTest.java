package com.group_22235.booking;

import java.time.LocalDate;
import java.time.LocalTime;

import com.group_22235.services_management.Station;

public class TicketTest {

	public static void main(String[] args) {

		LocalTime l = LocalTime.now();
		LocalDate d = LocalDate.now();

	    Station s = new Station("Town", "Letterkenny");
		Station s2 = new Station("Connolly", "Cork");

			TicketFacade a = new TicketFacade(s, s2, l, d, "FIRST");
		
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