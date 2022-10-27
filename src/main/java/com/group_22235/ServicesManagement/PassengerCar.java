package com.group_22235.ServicesManagement;

import java.util.ArrayList;

public class PassengerCar implements CarriageType{
    private ArrayList<Boolean> seats = new ArrayList<Boolean>();
    private Boolean firstClass = false;
    String freq = "Multiple times a day";

    public void setSeatStatus(int seatNum, Boolean occupied) {
        // -1 offset as no 0 seat like in arraylist
        seats.set(seatNum - 1, occupied);
    }

    public Boolean getSeatStatus(int seatNum) {
        return seats.get(seatNum);
    }

    public ArrayList<Boolean> getSeats() {
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
        return "Work Level:" + CarriageType.WorkLevel.HIGH + "\nFrequency: " + freq;
    }
}
