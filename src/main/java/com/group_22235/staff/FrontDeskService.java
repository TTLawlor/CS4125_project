package com.group_22235.staff;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.group_22235.generics.ABaseServiceImpl;

@Service
@Transactional
public class FrontDeskService extends ABaseServiceImpl<FrontDesk, Long> implements IFrontDeskService{
    
    public FrontDeskService(FrontDeskRepository fdRepository) {
        super(fdRepository);
    }

}
