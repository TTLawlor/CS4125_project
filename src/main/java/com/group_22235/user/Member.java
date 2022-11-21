package com.group_22235.user;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "MEMBER")
// @AttributeOverride(name = "user_id", column = @Column(name = "member_id"))
public class Member extends User {
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id", nullable = false)
    Account acc;

    @Column(name = "travel_points")
    int travelPoints;

    public Member(String name, String email, String password) {
        super(name, email);
        acc = new Account(password, false);
    }

    public void calcDiscount(){

    }
    
}
