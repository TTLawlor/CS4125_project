package com.group_22235.services_management;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
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

    @OneToMany(mappedBy = "train", cascade = CascadeType.ALL)
    private List<ACarriage> carriages = new ArrayList<ACarriage>();

    @Column(name = "num_carriages")
    private int numCarriages;

    @Transient
    private final int maxCarCount = 10;

    @Transient
    private CarriageFactoryService newCar = new CarriageFactoryService();

    @OneToMany
    @JoinColumn(name="train_id")
    private List<RouteTimetable> routes;

    
    // Default train is 7 passeneger cars and a storage car
    public Train() {
        ACarriage storageCar = newCar.createCarriage("STORAGE");
        storageCar.setTrain(this);
        carriages.add(storageCar);
        for(int i = 0; i < 7; i++) {
            ACarriage passCarriage = newCar.createCarriage("PASSENGER");
            passCarriage.setTrain(this);
            carriages.add(passCarriage);
        }

        setNumCarriages(carriages.size());
        routes = new ArrayList<RouteTimetable>();
    }

    public Train(List<RouteTimetable> rts) {
        this();
        routes = rts;
        setNumCarriages(carriages.size());
    }

    public Train(List<ACarriage> cars, List<RouteTimetable> rts) {
        this(rts);
        carriages = cars;
        setNumCarriages(carriages.size());
    }

    public void assignCar(ACarriage car) {
        // Check if carriage limit has been reached
        if(carriages.size() == maxCarCount) {
            System.out.printf("Maximum number for carraiages (%d) has already been reached/n", maxCarCount);
            return;
        }
        
        // Most likely to be passenger, so first check
        if(car.getType().equalsIgnoreCase("PASSENGER")) {
            carriages.add(car);
        }
        if(!hasDiningCar() && car.getType().equalsIgnoreCase("DINING")){
            carriages.add(car);
        }
        if(!hasStorageCar() && car.getType().equalsIgnoreCase("STORAGE")){
            carriages.add(car);
        }
        car.setTrain(this);
        setNumCarriages(carriages.size());
    }

    public void setNumCarriages(int numCarriages) {
        this.numCarriages = numCarriages;
    }

    public int getNumCarriages() {
        return numCarriages;
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
