package com.group_22235.staff;

import java.util.ArrayList;
import java.util.List;
public class StrikePublisher {
   // List of all classes in update list. Currently made up of Train and User
   private List<IObserverService> observers = new ArrayList<>();
   private StrikeReport rep;
   
   public StrikePublisher(StrikeReport rep) {
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
