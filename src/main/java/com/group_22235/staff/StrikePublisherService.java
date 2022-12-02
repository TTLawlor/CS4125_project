package com.group_22235.staff;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class StrikePublisherService {
   // List of all classes in update list. Currently made up of Train and User
   private List<IObserverService> observers = new ArrayList<>();
   private StrikeReport rep;
   
   public StrikePublisherService(StrikeReport rep) {
      this.rep = rep;
   }

   public void registerObserver(IObserverService o) {
      observers.add(o);
   }

   public void unregisterObserver(IObserverService o) {
      observers.remove(observers.indexOf(o));
   }

   public void notifyAllObservers(){
      for (IObserverService observer : observers) {
         observer.update(rep);
      }
   }
    
}
