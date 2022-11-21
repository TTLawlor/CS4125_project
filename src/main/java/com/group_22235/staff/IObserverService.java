package com.group_22235.staff;

import org.springframework.stereotype.Service;

@Service
public interface IObserverService {
    public StrikePublisherService strikePub = new StrikePublisherService();
    public void updateStrike();
}
