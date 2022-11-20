package com.group_22235.services_management;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.group_22235.generics.ABaseServiceImpl;

@Service
@Transactional
public class TrainService extends ABaseServiceImpl<Train, Long> implements ITrainService{

    public TrainService(TrainRepository tRepository) {
        super(tRepository);
    }
    

}
