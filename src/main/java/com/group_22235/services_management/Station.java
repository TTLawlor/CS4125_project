package com.group_22235.services_management;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.group_22235.generics.ABaseEntity;

@Entity
@Table(name = "STATION")
@AttributeOverride(name = "id", column = @Column(name = "station_id"))
public class Station extends ABaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "location")
    private String location;

    public Station(String name, String location) {
        this.location = location;
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
