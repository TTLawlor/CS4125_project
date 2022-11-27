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
import com.group_22235.user.User;

@Entity
@Table(name = "ADMIN")
// @AttributeOverride(name = "user_id", column = @Column(name = "admin_id"))
public class Admin extends User{
    public Admin(String name, String email, String password) {
        super(name, email, password, "ROLE_ADMIN");
    }

    public void updateRouteTimetbale(RouteTimetable oldRT, RouteTimetable newRT) {
        oldRT = newRT;
    }

    public void cancelRouteTimetable() {

    }

    public void callStrike(Report rep) {
        // Train t = new Train();
        // User u = new User(getName(), getEmail(), getPassword(), getRoles());
        // ???

        //for all trains and users, call strike
        // but we dont keep list of trains or users anywhere but db. what do?
        // This is bloody straightforwrad too i think am overhtinking
        

        StrikePublisherService str = new StrikePublisherService();
    }
}
