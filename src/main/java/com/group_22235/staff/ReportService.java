package com.group_22235.staff;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.group_22235.generics.ABaseServiceImpl;

@Service
@Transactional
public class ReportService extends ABaseServiceImpl<Report, Long> implements IReportService{
    
    public ReportService(ReportRepository rRepository) {
        super(rRepository);
    }

}
