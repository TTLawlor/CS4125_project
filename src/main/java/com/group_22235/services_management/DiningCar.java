package com.group_22235.services_management;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

@Entity
@Component
@DiscriminatorValue(value = "DINING")
public class DiningCar extends Carriage {
    // Could have menu?

    @Transient
    String freq = "Once a day";

    @Override
    public String cleaningRoutine() {
        return "Work Level:" + Carriage.WorkLevel.MODERATE + "\nFrequency: " + freq;
    }

    @Override
    public boolean checkStatus() {
        return true;
    }

}
