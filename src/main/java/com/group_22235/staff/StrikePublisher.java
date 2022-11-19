package com.group_22235.staff;

import java.util.ArrayList;
import java.util.List;

public class StrikePublisher {
    // Observer currently made up of Train and User
    private List<Observer> observers = new ArrayList<>();
    private int state;

    public int getState() {
        return state;
     }
  
     public void setState(int state) {
        this.state = state;
        notifyAllObservers();
     }
  
     public void attach(Observer observer){
        observers.add(observer);		
     }
  
     public void notifyAllObservers(){
        for (Observer observer : observers) {
           observer.updateStrike();
        }
     }
    
}
