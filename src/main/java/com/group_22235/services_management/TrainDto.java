package com.group_22235.services_management;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class TrainDto {
    private long trainId;
    private Train train;


    public Train getTrain() {
        return train;
    }
    public void setTrain(Train train) {
        this.train = train;
    }

    public long getTrainId() {
        return trainId;
    }
    public void setTrainId(long trainId) {
        this.trainId = trainId;
    }
    
}
