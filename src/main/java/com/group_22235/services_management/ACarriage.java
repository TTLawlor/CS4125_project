package com.group_22235.services_management;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.group_22235.generics.ABaseEntity;

@Entity
@Table(name = "CARRIAGE")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
    name = "CARRIAGE_TYPE",
    discriminatorType = DiscriminatorType.STRING
)
@AttributeOverride(name = "id", column = @Column(name = "carriage_id"))
public abstract class ACarriage extends ABaseEntity {
    enum WorkLevel {
        LOW,
        MODERATE,
        HIGH
    }
    
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "train_id")
    private Train train;
    
    
    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    // Should include work level: "Low, Moderate, High" and frequency: "Multiple times a day, Once a day, Every 3 days"
    public abstract String cleaningRoutine();

    public abstract boolean checkStatus();

    public abstract String getType();

}
