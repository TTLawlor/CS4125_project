package com.group_22235.booking;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.group_22235.generics.ABaseServiceImpl;

@Service
@Transactional
public class TicketService extends ABaseServiceImpl<TicketFacade, Long> implements ITicketService{

    protected TicketService(TicketRepository abstractBaseRepository) {
        super(abstractBaseRepository);
    }
    
}
