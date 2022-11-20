package com.group_22235.services_management;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
@DiscriminatorValue(value = "DINING")
public class DiningCar extends ACarriage {
    // Could have menu?

    @Transient
    String freq = "Once a day";

    @Override
    public String cleaningRoutine() {
        return "Work Level:" + ACarriage.WorkLevel.MODERATE + "\nFrequency: " + freq;
    }

    @Override
    public boolean checkStatus() {
        return true;
    }

    @Override
    public String getType() {
        return "DINING";
    }

}
