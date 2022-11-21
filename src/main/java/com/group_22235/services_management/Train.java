package com.group_22235.services_management;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.group_22235.generics.ABaseEntity;
import com.group_22235.staff.IObserverService;

@Entity
@Table(name = "TRAIN")
@AttributeOverride(name = "id", column = @Column(name = "train_id"))
public class Train extends ABaseEntity implements IObserverService{

    @OneToMany(mappedBy = "train")
    private List<ACarriage> carriages = new ArrayList<ACarriage>();

    @Column(name = "num_carriages")
    private final int maxCarCount = 10;

    @Transient
    private CarriageFactoryService newCar = new CarriageFactoryService();;

    @OneToMany
    @JoinColumn(name="train_id", nullable=false)
    private List<RouteTimetable> routes;

    
    // Default train is 6 passeneger cars and a storage car
    public Train() {
        carriages.add(newCar.createCarriage("STORAGE"));
        for(int i = 0; i < 7; i++) {
            carriages.add(newCar.createCarriage("PASSENGER"));
        }

        routes = new ArrayList<RouteTimetable>();
    }

    public Train(ArrayList<RouteTimetable> rts) {
        this();
        routes = rts;
    }

    public Train(ArrayList<ACarriage> cars, ArrayList<RouteTimetable> rts) {
        this(rts);
        carriages = cars;
    }

    public void assignCar(ACarriage car) {
        // Check if carriage limit has been reached
        if(carriages.size() == maxCarCount) {
            System.out.printf("Maximum number for carraiages (%d) has already been reached/n", maxCarCount);
            return;
        }
        
        // Most likely to be passenger, so first check
        if(car instanceof PassengerCar) {
            carriages.add(car);
        }
        if(!hasDiningCar() && car instanceof DiningCar){
            carriages.add(car);
        }
        if(!hasStorageCar() && car instanceof StorageCar){
            carriages.add(car);
        }
    }

    public List<ACarriage> listCars(){
        return carriages;   
    }

    public Boolean hasDiningCar(){
        for (ACarriage car : carriages) {
            if(car instanceof DiningCar) return true;
        }
        return false;
    }

    public Boolean hasStorageCar(){
        for (ACarriage car : carriages) {
            if(car instanceof StorageCar) return true;
        }
        return false;
    }

    public List<RouteTimetable> getRoutes() {
        return routes;
    }

    public void setRoutes(List<RouteTimetable> routes) {
        this.routes = routes;
    }

    @Override
    public void updateStrike() {
        // Cancel train for the day by wiping all routes for the train
        routes.clear();
    }
}
