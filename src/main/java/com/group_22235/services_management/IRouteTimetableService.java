package com.group_22235.services_management;

import java.util.List;

import com.group_22235.generics.IBaseService;

public interface IRouteTimetableService extends IBaseService<RouteTimetable, Long>{
    public abstract List<RouteTimetable> findAllByTrainID(Long trainId);
    public abstract List<RouteTimetable> findByStationIDs(Long st1_id, Long st2_id);
}
