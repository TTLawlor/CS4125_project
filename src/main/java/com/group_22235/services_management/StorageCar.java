package com.group_22235.services_management;

import org.springframework.stereotype.Component;

@Component
public class StorageCar implements CarriageType{
    String freq = "Every 3 days";

    @Override
    public String cleaningRoutine() {
        return "Work Level:" + CarriageType.WorkLevel.LOW + "\nFrequency: " + freq;
    }

    @Override
    public Type getCarriageType() {
        return Type.STORAGE;
    }

}
