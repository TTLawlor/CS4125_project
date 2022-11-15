package com.group_22235.services_management;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

@Entity
@Component
@DiscriminatorValue(value = "PASSENGER")
public class PassengerCar extends Carriage{

    @Column(name = "first_class")
    private Boolean firstClass = false;

    @Column(name = "total_seats")
    private int seatNum;

    @Column(name = "seats_avaliable")
    private int seatsAvaliable;

    @Transient
    private List<Boolean> seats = new ArrayList<Boolean>();

    @Transient
    String freq = "Multiple times a day";

    public void setSeatStatus(int seatNum, Boolean occupied) {
        this.seatNum = seatNum;
        // -1 offset as no 0 seat like in arraylist
        seats.set(seatNum - 1, occupied);
    }
 
    public int getSeatNum() {
        return seatNum;
    }

    public int getSeatsAvaliable() {
        int seatsAvaliable = 0;
        for (Boolean value : seats) {
            // if value is equal to True
            if (value.booleanValue()) {
                seatsAvaliable ++;
            }
        }
        return seatsAvaliable;
    }

    public Boolean getSeatStatus(int seatNum) {
        return seats.get(seatNum);
    }

    public List<Boolean> getSeats() {
        return seats;
    }

    public void setFirstClass(Boolean firstClass) {
        this.firstClass = firstClass;
    }

    public Boolean getFirstClass() {
        return firstClass;
    }

    @Override
    public String cleaningRoutine() {
        return "Work Level:" + Carriage.WorkLevel.HIGH + "\nFrequency: " + freq;
    }

    @Override
    public boolean checkStatus() {
        return true;
    }
}
