package com.group_22235.booking;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group_22235.generics.ABaseServiceImpl;

@Service
@Transactional
public class TicketService extends ABaseServiceImpl<TicketFacade, Long> implements ITicketService{

    @Autowired
    private TicketRepository ticketRepository;

    protected TicketService(TicketRepository abstractBaseRepository) {
        super(abstractBaseRepository);
    }

    @Override
    public void saveTicket(TicketDto ticketDto) {
        TicketFacade ticket = new TicketFacade();
        ticket.setArrStation(ticketDto.getArrStation());
        ticket.setDepStation(ticketDto.getDepStation());
        ticket.setTicketType(ticketDto.getTicketType());
        ticket.setDate(ticketDto.getDate());
        ticket.setTicketType(ticketDto.getTicketType());
        getPassPrice(ticketDto, ticket);
        ticketRepository.save(ticket);
    }

    public void getPassPrice(TicketDto ticketDto, TicketFacade ticket) {
        switch(ticketDto.getPassType()) {
            case "ADULT":
                ticket.setAdultPrice();
              break;
            case "CHILD":
                ticket.setChildPrice();
              break;
            case "YA":
                ticket.setYAPrice();
              break;
              case "OAP":
                ticket.setOAPPrice();
              break;
          }
    }

    
    
}
