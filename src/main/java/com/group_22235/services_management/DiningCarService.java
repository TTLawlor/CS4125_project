package com.group_22235.services_management;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.group_22235.generics.ABaseServiceImpl;

@Service
@Transactional
public class DiningCarService extends ABaseServiceImpl<ACarriage, Long> implements ICarriageService{

    public DiningCarService(DiningCarRepository dRepository) {
        super(dRepository);
    }
    
}
