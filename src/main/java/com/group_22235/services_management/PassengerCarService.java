package com.group_22235.services_management;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group_22235.generics.ABaseServiceImpl;


@Service
@Transactional
public class PassengerCarService extends ABaseServiceImpl<ACarriage, Long> implements ICarriageService{
    
    @Autowired
    private PassengerCarRepository pRepository;

    public PassengerCarService(PassengerCarRepository pRepository) {
        super(pRepository);
    }

    @Override
    public List<ACarriage> findAll() {
        List<ACarriage> pCarriages = new ArrayList<>();
        for (ACarriage carriage : pRepository.findAll()) {
            if(carriage.getType().equalsIgnoreCase("PASSENGER")){
                pCarriages.add(carriage);
            }
        }
        return pCarriages;
    }
}
