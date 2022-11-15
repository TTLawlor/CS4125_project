package com.group_22235.services_management;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

@Entity
@Component
@DiscriminatorValue(value = "STORAGE")
public class StorageCar extends Carriage{
    
    @Transient
    String freq = "Every 3 days";

    @Override
    public String cleaningRoutine() {
        return "Work Level:" + Carriage.WorkLevel.LOW + "\nFrequency: " + freq;
    }

    @Override
    public boolean checkStatus() {
        return true;
    }
}
