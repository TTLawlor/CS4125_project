package com.group_22235.services_management;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group_22235.generics.ABaseServiceImpl;
import com.group_22235.staff.StrikeReport;

@Service
@Transactional
public class TrainService extends ABaseServiceImpl<Train, Long> implements ITrainService{

    @Autowired 
    RouteTimetableService routeTimetableService;
    
    public TrainService(TrainRepository tRepository) {
        super(tRepository);
    }

    public void updateStrike(Train train, StrikeReport report) {
        train.update(report);
        for (RouteTimetable routeTimetable : routeTimetableService.findAllByTrainID(train.getId())) {
            routeTimetableService.deleteById(routeTimetable.getId());
        }
    }

}
