package com.group_22235.booking;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.group_22235.services_management.Station;

@SpringBootTest
class TicketTest {

	// @Autowired
    // private TicketService tService;
	@Test
	void should_test_something(){

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
			System.out.println(a.getDate());
			System.out.println(a.getTime());

			// tService.save(a);
			
	}

}