package com.group_22235.services_management;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.group_22235.generics.ABaseServiceImpl;

@Service
@Transactional
public class RouteTimetableService extends ABaseServiceImpl<RouteTimetable, Long> implements IRouteTimetableService{

    public RouteTimetableService(RouteTimetableRepository rRepository) {
        super(rRepository);
    }
    
}
