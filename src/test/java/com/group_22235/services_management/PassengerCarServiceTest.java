package com.group_22235.services_management;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class PassengerCarServiceTest {
    

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    PassengerCarRepository repository;

    @Autowired
    TrainRepository trainRepository;

    
    @Test
    void should_find_all_passenger_cars() throws Exception {
        CarriageFactoryService cFactoryService = new CarriageFactoryService();
        ACarriage passCar1 = cFactoryService.createCarriage("PASSENGER");
        ACarriage passCar2 = cFactoryService.createCarriage("PASSENGER");
        entityManager.persist(passCar1);
        entityManager.persist(passCar2);

        assertThat(repository.findAll()).contains(passCar1, passCar2);
    }

    @Test
    void should_find_train_associated_with_car() throws Exception {
        CarriageFactoryService cFactoryService = new CarriageFactoryService();
        ACarriage passCar1 = cFactoryService.createCarriage("PASSENGER");

        Train train = new Train();
        train.assignCar(passCar1);
        entityManager.persist(train);

        long expected_id = train.getId();
        long actual_id = passCar1.getTrain().getId();
        assertEquals(expected_id, actual_id);
    }

    @Test
    void should_return_car_worklevel() throws Exception {
        CarriageFactoryService cFactoryService = new CarriageFactoryService();
        ACarriage passCar1 = cFactoryService.createCarriage("PASSENGER");

        assertTrue(passCar1.cleaningRoutine().contains("HIGH"));
    }

}
