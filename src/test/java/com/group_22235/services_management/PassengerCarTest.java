package com.group_22235.services_management;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PassengerCarTest {

    @Test
    void should_get_seat_status(){
    CarriageFactoryService cFactoryService = new CarriageFactoryService();
    ACarriage car = cFactoryService.createCarriage("PASSENGER");
    PassengerCar passCar1 = (PassengerCar) car;
    passCar1.setTotalSeats();
    passCar1.setSeatStatus(15, true);

    assertEquals(true, passCar1.getSeatStatus(15));
    }

   @Test
    void should_get_available_seats(){
    CarriageFactoryService cFactoryService = new CarriageFactoryService();
    ACarriage car = cFactoryService.createCarriage("PASSENGER");
    PassengerCar passCar1 = (PassengerCar) car;
    passCar1.setTotalSeats();
    passCar1.setSeatStatus(15, false);
    passCar1.getSeatsAvaliable();
    
    assertEquals(39, passCar1.getSeatsAvaliable());
    } 

    @Test
    void should_set_first_class(){
    CarriageFactoryService cFactoryService = new CarriageFactoryService();
    ACarriage car = cFactoryService.createCarriage("PASSENGER");
    PassengerCar passCar1 = (PassengerCar) car;
    passCar1.setTotalSeats();
    passCar1.setFirstClass(true);
    
    assertTrue(passCar1.getFirstClass());
    }

    @Test
    void should_check_status(){
    CarriageFactoryService cFactoryService = new CarriageFactoryService();
    ACarriage car = cFactoryService.createCarriage("PASSENGER");
    PassengerCar passCar1 = (PassengerCar) car;
    
    assertTrue(passCar1.checkStatus());
    }

    @Test
    void should_get_carriage_type(){
    CarriageFactoryService cFactoryService = new CarriageFactoryService();
    ACarriage car = cFactoryService.createCarriage("PASSENGER");
    PassengerCar passCar1 = (PassengerCar) car;
    
    assertEquals("PASSENGER", passCar1.getType());
    }
}