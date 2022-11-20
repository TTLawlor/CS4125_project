package com.group_22235.user;

public class Account {
    String password;
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
