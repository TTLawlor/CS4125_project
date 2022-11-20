package com.group_22235.services_management;

import org.springframework.stereotype.Service;


@Service
public class CarriageFactoryService {

    public ACarriage createCarriage(String carType) {
        if(carType == null){
            throw new RuntimeException("Unknown carriage type: " + carType);
        } 
        if(carType.equalsIgnoreCase("PASSENGER")) {
            return new PassengerCar();
        } else if(carType.equalsIgnoreCase("STORAGE")) {
            return new StorageCar();
        } else if(carType.equalsIgnoreCase("DINING")) {
            return new DiningCar();
        }
        return null;
    }
}
