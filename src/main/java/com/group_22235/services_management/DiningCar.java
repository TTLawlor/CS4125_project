package com.group_22235.services_management;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.springframework.stereotype.Component;

@Entity
@Component
@DiscriminatorValue(value = "DINING")
public class DiningCar extends Carriage {
    // Could have menu?

    String freq = "Once a day";

    @Override
    public String cleaningRoutine() {
        return "Work Level:" + Carriage.WorkLevel.MODERATE + "\nFrequency: " + freq;
    }

    @Override
    public String getCarriageType() {
        return "Dining carriage";
    }

    @Override
    public boolean checkStatus() {
        return true;
    }

}
