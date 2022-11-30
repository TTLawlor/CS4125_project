package com.group_22235.booking;

import com.group_22235.services_management.Station;

public class TicketTest {

	public static void main(String[] args) {

	    Station s = new Station("Town", "Letterkenny");
		Station s2 = new Station("Connolly", "Cork");

	//	Ticket v = new Ticket(s , s2 , "YA", "1:00",
	//	2022, 11, 28, "FLEX");
		

		// System.out.println(s.getLocation() + "-> " + s2.getLocation());
		// System.out.println(v.getTicketPrice());
		// System.out.println(v.getTimeLimit());
		// System.out.println(v.getFirstClass());
		// System.out.println(v.getDate());

		System.out.println("--------------");

	//	Ticket g = new Ticket(s , s2 , "YA", "1:00",
	//	2022, 11, 28, "SEMI");


			  // ShapeMaker shapeMaker = new ShapeMaker();
			 // Ticket tick = new Ticket(s, s2, "Child", "2:00", 22, 3, 2022, "FLEX") ;
			   TicketFacade aticket = new TicketFacade(s, s2, "Child", "2:00", 22, 3, 2022, "FLEX");
		 		
			   aticket.getChildPrice();	
			   System.out.println(aticket.getArrStation());
			
		 
	}

}