package com.group_22235.booking;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Executable;
import java.time.LocalDate;
import java.time.LocalTime;

import org.assertj.core.api.junit.jupiter.InjectSoftAssertions;
import org.junit.jupiter.api.Test;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.group_22235.services_management.Station;

@SpringBootTest
class TicketTest {

	// @Autowired
    // private TickebtService tService;

	LocalTime l = LocalTime.of(10,30);
	LocalDate d = LocalDate.of(2022,11,11);

	Station s = new Station("Letterkenny Town", "Letterkenny");
	Station s2 = new Station("Connolly", "Cork");

	@Test
	void should_generate_young_adult_first_class(){

			TicketFacade a = new TicketFacade(s, s2, l, d, "FIRST");
		
			//(s.getLocation() + "-> " + s2.getLocation();
			a.getTicketPrice();
			a.setYAPrice();
			a.getYAPrice();
			a.getTimeLimit();
			a.getFirstClass();
			a.getDate();
			a.getTime();


			Double exp = 7.5;

			assertEquals(exp, a.getYAPrice()); 
			assertEquals(exp, a.getYAPrice());
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

		double exp = 5;
		assertEquals(exp, c.getAdultPrice());
	}

	@Test
	void should_generate_oap_first_class(){

		TicketFacade dd = new TicketFacade(s, s2, l, d, "FIRST");

		dd.setOAPPrice();
		dd.getOAPPrice();

		double exp = 7.50;
		assertEquals(exp, dd.getOAPPrice());
	}

	@Test
	public void test_ticket_type_throws_exceeption() {
          
    assertThrows(IllegalArgumentException.class, () -> {
        TicketFacade e = new TicketFacade(s, s2, l, d, "invalid");
        e.setTicketType("invalid");
    });
}
}