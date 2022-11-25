package com.group_22235.user;

public class Member extends User {
    Account acc;
    int travelPoints;

    public Member(String name, String email, String password) {
        super(name, email);
        acc = new Account(password, false);
    }

    public void calcDiscount(){

    }
    
}
