package com.group_22235.services_management;

import org.springframework.stereotype.Component;

@Component
public class DiningCar implements CarriageType {
    // Could have menu?

    String freq = "Once a day";

    @Override
    public String cleaningRoutine() {
        return "Work Level:" + CarriageType.WorkLevel.MODERATE + "\nFrequency: " + freq;
    }

    @Override
    public Type getCarriageType() {
        return Type.DINING;
    }

}
