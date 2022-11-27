package com.group_22235.user;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.group_22235.generics.ABaseServiceImpl;

@Service
@Transactional
public class PassengerService extends ABaseServiceImpl<Passenger, Long> implements IPassengerService{
    
    public PassengerService(PassengerRepository mRepository) {
        super(mRepository);
    }
    

}
