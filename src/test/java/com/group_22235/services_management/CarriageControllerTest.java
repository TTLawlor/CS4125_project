package com.group_22235.services_management;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

// import com.group_22235.services_management.CarriageType.Type;

public class CarriageControllerTest {


    @Autowired
    private Carriage cFactory;

    
    @Test
    void testGetCarriageType() throws Exception {
        // CarriageFactory cFactory = new CarriageFactory();
        // CarriageType car1 = cFactory.createCarriage(Type.PASSENGER);
        assertNotNull(cFactory);
        // CarriageType car1 = cFactory.createCarriage(Type.PASSENGER);
        // String r = controller.getCarriageCleanRoutine(car1.getCarriageType());
    }
}
