package com.group_22235.ServicesManagement;

public class ConcCarTypeCreator {
    public CarriageType createCarriage(String carType) {
        if(carType == null){
            return null;
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
