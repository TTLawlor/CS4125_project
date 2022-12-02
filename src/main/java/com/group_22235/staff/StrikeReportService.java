package com.group_22235.staff;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.group_22235.generics.ABaseServiceImpl;

@Service
@Transactional
public class StrikeReportService extends ABaseServiceImpl<StrikeReport, Long> implements IStrikeReportService{
    
    public StrikeReportService(StrikeReportRepository rRepository) {
        super(rRepository);
    }

}