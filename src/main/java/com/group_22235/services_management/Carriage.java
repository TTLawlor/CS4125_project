package com.group_22235.services_management;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
    name = "CARRIAGE",
    discriminatorType = DiscriminatorType.STRING
)
public abstract class Carriage {
    enum WorkLevel {
        LOW,
        MODERATE,
        HIGH
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
    private long carriageID;
    
    // Should include work level: "Low, Moderate, High" and frequency: "Multiple times a day, Once a day, Every 3 days"
    public abstract String cleaningRoutine();

    public abstract boolean checkStatus();

}
