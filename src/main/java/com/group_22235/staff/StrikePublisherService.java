package com.group_22235.staff;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class StrikePublisherService {
    // Observer currently made up of Train and User
    private List<IObserverService> observers = new ArrayList<>();
    private int state;

    public int getState() {
        return state;
     }
  
     public void setState(int state) {
        this.state = state;
        notifyAllObservers();
     }
  
     public void attach(IObserverService observer){
        observers.add(observer);		
     }
  
     public void notifyAllObservers(){
        for (IObserverService observer : observers) {
           observer.updateStrike();
        }
     }
    
}
