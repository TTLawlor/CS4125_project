package com.group_22235.generics;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class ABaseEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    public long getId() {
        return id;
    }

}
