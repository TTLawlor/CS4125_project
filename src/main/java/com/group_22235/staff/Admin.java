package com.group_22235.staff;

import com.group_22235.services_management.RouteTimetable;
import com.group_22235.user.Account;
import com.group_22235.user.User;

public class Admin extends User{
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
