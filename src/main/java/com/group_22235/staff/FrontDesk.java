package com.group_22235.staff;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.group_22235.services_management.Station;
import com.group_22235.user.Account;
import com.group_22235.user.User;

@Entity
@Table(name = "FRONT_DESK")
// @AttributeOverride(name = "user_id", column = @Column(name = "front_desk_id"))
public class FrontDesk extends User{
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id", nullable = false)
    Account acc;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "station_id", nullable = false)
    Station station;

    // public FrontDesk(String name, String email, String password, String roles, Boolean active, Station station) {
    //     super(name, email, password, roles, active);
    //     this.station = station;
    //     acc = new Account(password, true);
    // }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }
}
