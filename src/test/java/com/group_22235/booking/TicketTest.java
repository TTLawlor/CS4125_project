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

	LocalTime l = LocalTime.now();
	LocalDate d = LocalDate.now();

	Station s = new Station("Town", "Letterkenny");
	Station s2 = new Station("Connolly", "Cork");

	@Test
	void should_generate_young_adult_first_class(){

			TicketFacade a = new TicketFacade(s, s2, l, d, "FIRST");
		
			System.out.println(s.getLocation() + "-> " + s2.getLocation());
			System.out.println(a.getTicketPrice());
			a.setYAPrice();
			System.out.println("Young Adult price: " + a.getYAPrice());
			System.out.println(a.getTimeLimit());
			System.out.println(a.getFirstClass());
			System.out.println(a.getDate());
			System.out.println(a.getTime());

			// tService.save(a);
			
	}

	@Test
	void should_generate_child_flexible(){

		TicketFacade b = new TicketFacade(s, s2, l, d, "FLEX");

		b.getDepStation();
		b.getArrStation();
		b.setChildPrice();
		b.getChildPrice();
	}

	@Test
	void should_generate_adult_semi(){

		TicketFacade c = new TicketFacade(s, s2, l, d, "SEMI");

		c.setAdultPrice();
		c.getAdultPrice();
		c.getTicketType();
	}

	@Test
	void should_generate_oap_first_class(){

		TicketFacade dd = new TicketFacade(s, s2, l, d, "FIRST");

		dd.setOAPPrice();
		dd.getOAPPrice();

	}
}