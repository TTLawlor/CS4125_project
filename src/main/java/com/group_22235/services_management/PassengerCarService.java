package com.group_22235.services_management;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;


@Service
@Transactional
public class PassengerCarService extends BaseServiceImpl<Carriage, Long> implements ICarriageService{
    
    // private PassengerCarRepository Passrepository;
    public PassengerCarService(PassengerCarRepository Passrepository) {
        super(Passrepository);
    }

    //business logic

}
