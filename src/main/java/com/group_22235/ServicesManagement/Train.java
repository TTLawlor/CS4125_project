package com.group_22235.ServicesManagement;

import java.util.ArrayList;
import java.util.List;

public class Train {
    private List<CarriageType> carriages;
    private final int maxCarCount = 10;
    private CarriageFactory newCar;
    private List<RouteTimetable> routes;

    // Default train is 6 passeneger cars and a storage car
    public Train() {
        carriages = new ArrayList<>();
        newCar = new CarriageFactory();

        carriages.add(newCar.createCarriage("STORAGE"));
        for(int i = 0; i < 7; i++) {
            carriages.add(newCar.createCarriage("PASSENGER"));
        }

        routes = new ArrayList<RouteTimetable>();
    }

    public Train(ArrayList<RouteTimetable> rts) {
        this();
        routes = rts;
    }

    public Train(ArrayList<CarriageType> cars, ArrayList<RouteTimetable> rts) {
        this(rts);
        carriages = cars;
    }

    public void assignCar(CarriageType car) {
        // Check if carriage limit has been reached
        if(carriages.size() == maxCarCount) {
            System.out.printf("Maximum number for carraiages (%d) has already been reached/n", maxCarCount);
            return;
        }
        
        // Most likely to be passenger, so first check
        if(car instanceof PassengerCar) {
            carriages.add(car);
        }
        if(!hasDiningCar() && car instanceof DiningCar){
            carriages.add(car);
        }
        if(!hasStorageCar() && car instanceof StorageCar){
            carriages.add(car);
        }
    }

    public List<CarriageType> listCars(){
        return carriages;   
    }

    public Boolean hasDiningCar(){
        for (CarriageType car : carriages) {
            if(car instanceof DiningCar) return true;
        }
        return false;
    }

    public Boolean hasStorageCar(){
        for (CarriageType car : carriages) {
            if(car instanceof StorageCar) return true;
        }
        return false;
    }

    public List<RouteTimetable> getRoutes() {
        return routes;
    }

    public void setRoutes(List<RouteTimetable> routes) {
        this.routes = routes;
    }
}
