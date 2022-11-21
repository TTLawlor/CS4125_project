package com.group_22235.staff;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.group_22235.services_management.RouteTimetable;
import com.group_22235.user.Account;
import com.group_22235.user.User;

@Entity
@Table(name = "ADMIN")
// @AttributeOverride(name = "user_id", column = @Column(name = "admin_id"))
public class Admin extends User{
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id", nullable = false)
    Account acc;

    public Admin(String name, String email, String password) {
        super(name, email);
        acc = new Account(password, true);
    }

    public void updateRouteTimetbale(RouteTimetable oldRT, RouteTimetable newRT) {
        oldRT = newRT;
    }

    public void cancelRouteTimetable() {

    }
}
