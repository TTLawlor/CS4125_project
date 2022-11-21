package com.group_22235.user;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.group_22235.generics.ABaseEntity;

@Entity
@Table(name = "ACCOUNT")
@AttributeOverride(name = "id", column = @Column(name = "account_id"))
public class Account extends ABaseEntity{

    @Column(name = "password")
    String password;

    @Column(name = "staff")
    Boolean isStaff;

    public Account(String password, Boolean isStaff) {
        this.password = password;
        this.isStaff = isStaff;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getIsStaff() {
        return isStaff;
    }
}
