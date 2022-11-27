package com.group_22235.staff;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.group_22235.services_management.Station;
import com.group_22235.user.User;

@Entity
@Table(name = "FRONT_DESK")
// @AttributeOverride(name = "user_id", column = @Column(name = "front_desk_id"))
public class FrontDesk extends User{
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "station_id", nullable = false)
    Station station;

    public FrontDesk(String name, String email, String password, Station station) {
        super(name, email, password, "ROLE_FRONTDESK");
        this.station = station;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    // Should this just be an access thing?
    public void makeReport(Report report) {
        // log in db
    }
}
