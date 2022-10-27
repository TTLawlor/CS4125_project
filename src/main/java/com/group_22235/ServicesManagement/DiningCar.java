package com.group_22235.ServicesManagement;

public class DiningCar implements CarriageType {
    // Could have menu?

    String freq = "Once a day";

    @Override
    public String cleaningRoutine() {
        return "Work Level:" + CarriageType.WorkLevel.MODERATE + "\nFrequency: " + freq;
    }
}
