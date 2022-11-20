package com.group_22235.services_management;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

public class CarriageControllerTest {


    @Autowired
	private TestEntityManager entityManager;

    
    @Test
    void testGetCarriageType() throws Exception {
        // String r = controller.getCarriageCleanRoutine(car1.getCarriageType());
    }
}
