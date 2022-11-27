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
import com.group_22235.staff.StrikeReport;

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

    public Train(ArrayList<ACarriage> cars, ArrayList<RouteTimetable> rts) throws ArrayIndexOutOfBoundsException {
        if(cars.size() > maxCarCount) {
            throw new ArrayIndexOutOfBoundsException(String.format("Too many cars being added, max is %d/n", maxCarCount));
        }
        carriages = cars;
        routes = rts;
    }

    public void assignCar(ACarriage car) throws Exception {
        // Check if carriage limit has been reached
        if(carriages.size() == maxCarCount) {
            throw new ArrayIndexOutOfBoundsException(String.format("Maximum number for carraiages (%d) has already been reached/n", maxCarCount));
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

    // If this is called, we can presume car of that type pre-exists
    public void removeCar(ACarriage car) throws Exception {
        if(carriages.size() == 0) {
            throw new ArrayIndexOutOfBoundsException("No carraiages added yet");
        }
        
        carriages.remove(car);
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

    // Removes any affected RouteTimetables from routes list
    @Override
    public void update(StrikeReport rep) {
        for (RouteTimetable affRt : rep.getAffectedRoutes()){
            for (int i = 0; i < routes.size(); i++) {
                if(affRt == routes.get(i)) {
                    routes.remove(i);
                    i--;    // Offsets since one val was taken out, otherwise would skip the new val in the pos of aold one
                }
            }
        }        
    }
}
