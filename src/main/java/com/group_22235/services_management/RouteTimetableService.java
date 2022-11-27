package com.group_22235.services_management;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group_22235.generics.ABaseServiceImpl;

@Service
@Transactional
public class RouteTimetableService extends ABaseServiceImpl<RouteTimetable, Long> implements IRouteTimetableService{

    @Autowired
    private RouteTimetableRepository rRepository;

    public RouteTimetableService(RouteTimetableRepository rRepository) {
        super(rRepository);
    }

    public List<RouteTimetable> findAllByTrainID(Long trainId) {
        return rRepository.findAllByTrainID(trainId);
    }
    
}
