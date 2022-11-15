package com.group_22235.services_management;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.group_22235.generics.ABaseServiceImpl;

@Service
@Transactional
public class StationService extends ABaseServiceImpl<Station, Long> implements IStationService{

    public StationService(StationRepository sRepository) {
        super(sRepository);
    }
    
}
