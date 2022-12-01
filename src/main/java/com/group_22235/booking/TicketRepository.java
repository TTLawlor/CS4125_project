package com.group_22235.booking;

import org.springframework.stereotype.Repository;

import com.group_22235.generics.IBaseRepository;

@Repository
public interface TicketRepository extends IBaseRepository<TicketFacade, Long>{
    
}
