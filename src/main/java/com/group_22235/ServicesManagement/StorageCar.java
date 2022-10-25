package com.group_22235.ServicesManagement;

public class StorageCar implements CarriageType{
    String freq = "Every 3 days";

    @Override
    public String cleaningRoutine() {
        return "Work Level:" + CarriageType.WorkLevel.LOW + "\nFrequency: " + freq;
    }
    
}
