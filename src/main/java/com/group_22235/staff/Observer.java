package com.group_22235.staff;

public interface Observer {
    public StrikePublisher strikePub = new StrikePublisher();
    public void updateStrike();
}
