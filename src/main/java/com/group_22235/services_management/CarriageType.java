package com.group_22235.services_management;

public interface CarriageType {
    enum WorkLevel {
        LOW,
        MODERATE,
        HIGH
    }

    enum Type {
        DINING,
        STORAGE,
        PASSENGER
        
    }

    // Should include work level: "Low, Moderate, High" and frequency: "Multiple times a day, Once a day, Every 3 days"
    String cleaningRoutine();

    Type getCarriageType();

}
