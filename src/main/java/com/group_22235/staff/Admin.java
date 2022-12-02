package com.group_22235.staff;

import javax.management.relation.Role;
import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.group_22235.services_management.RouteTimetable;
import com.group_22235.services_management.Train;
import com.group_22235.user.Passenger;
import com.group_22235.user.User;

@Entity
@Table(name = "ADMIN")
// @AttributeOverride(name = "user_id", column = @Column(name = "admin_id"))
public class Admin extends User{
    public Admin(String name, String email, String password) {
        super(name, email, password, "ROLE_ADMIN");
    }

    public void updateRouteTimetable(RouteTimetable oldRT, RouteTimetable newRT) {
        oldRT = newRT; 
    }

    public void cancelRouteTimetable() {

    }

    public void callStrike(StrikeReport report, Train train, Passenger pass) {
        StrikePublisher str = new StrikePublisher(report);
        str.registerObserver(train);
        str.registerObserver(pass);

        str.notifyAllObservers();
    }
}
