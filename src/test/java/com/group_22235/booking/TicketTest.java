package com.group_22235.booking;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cglib.core.Local;

import com.group_22235.services_management.Station;

@SpringBootTest
class TicketTest {

	// @Autowired
    // private TickebtService tService;

	LocalTime l = LocalTime.of(10,30);
	LocalTime z = LocalTime.of(12,30);
	LocalDate d = LocalDate.of(2022,11,11);

	Station s = new Station("Letterkenny Town", "Letterkenny");
	Station s2 = new Station("Connolly", "Cork");

	@Test
	void should_generate_young_adult_first_class(){

			TicketFacade a = new TicketFacade(s, s2, l, z, d, "FIRST");
		
			//(s.getLocation() + "-> " + s2.getLocation();
			a.getTicketPrice();
			a.setYAPrice();
			a.getYAPrice();
			a.getTimeLimit();
			a.getDate();
			a.getDepTime();


			int tl = 23;
			Double exp = 7.5;

			assertEquals(tl, a.getTimeLimit()); 
			assertEquals(exp, a.getYAPrice());
			// tService.save(a);
			
	}

	@Test
	void should_generate_child_flexible(){

		TicketFacade b = new TicketFacade(s, s2, l, z, d, "FLEX");

		b.getDepStation();
		b.getArrStation();
		b.setChildPrice();
		b.getChildPrice();

		double exp = 2;
		assertEquals(exp, b.getChildPrice());
	}

	@Test
	void should_generate_adult_semi(){

		TicketFacade c = new TicketFacade(s, s2, l, z, d, "SEMI");

		c.setAdultPrice();
		c.getAdultPrice();
		c.getTicketType();

		double exp = 5;
		assertEquals(exp, c.getAdultPrice());
	}

	@Test
	void should_generate_oap_first_class(){

		TicketFacade dd = new TicketFacade(s, s2, l, z, d, "FIRST");

		dd.setOAPPrice();
		dd.getOAPPrice();

		double exp = 7.50;
		assertEquals(exp, dd.getOAPPrice());
	}

	@Test
	void should_generate_master_ticket(){

		TicketFacade f = new TicketFacade(s, s2, l, z, d, "MASTER");

		assertEquals(0, f.getTimeLimit());
	}

	@Test
	void should_throw_exceeption() {
          
    assertThrows(IllegalArgumentException.class, () -> {
        TicketFacade e = new TicketFacade(s, s2, l, z, d, "invalid");
        e.setTicketType("invalid");
    });
   }

   @Test
   void should_set_price(){

	   TicketFacade f = new TicketFacade(s, s, z, l, d, "FLEX");
	   f.setTicketPrice(3);

	   assertEquals(3, f.getTicketPrice());
   }

   @Test
   void should_set_time(){

	   TicketFacade f = new TicketFacade(s, s, z, l, d, "FLEX");
		LocalTime dep = LocalTime.of(2,30);
		LocalTime arr = LocalTime.of(5,30);
	    f.setDepTime(dep);
		f.setArrTime(arr);

		assertEquals(dep, f.getDepTime());
	    assertEquals(arr, f.getArrTime());
   }

}