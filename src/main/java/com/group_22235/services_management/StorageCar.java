package com.group_22235.services_management;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
@DiscriminatorValue(value = "STORAGE")
public class StorageCar extends ACarriage{
    
    @Transient
    String freq = "Every 3 days";

    @Override
    public String cleaningRoutine() {
        return "Work Level:" + ACarriage.WorkLevel.LOW + "\nFrequency: " + freq;
    }

    @Override
    public boolean checkStatus() {
        return true;
    }

    @Override
    public String getType() {
        return "STORAGE";
    }
}
