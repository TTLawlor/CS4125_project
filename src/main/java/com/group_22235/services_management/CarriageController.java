package com.group_22235.services_management;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarriageController {
    
    @GetMapping("/carriage/{carriage-type}")
    public String getCarriageType(@PathVariable("carriage-type") CarriageType.Type carriage) throws Exception {
        CarriageType carriageFactory = CarriageFactory.createCarriage(carriage);
        return carriageFactory.cleaningRoutine();
    }

}
