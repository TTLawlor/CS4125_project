package com.group_22235.user;

import java.util.ArrayList;
import java.util.List;

// import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.group_22235.booking.TicketFacade;
import com.group_22235.payment.IPaymentStrategy;
import com.group_22235.payment.Subscription;
import com.group_22235.staff.IObserverService;
import com.group_22235.staff.StrikeReport;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Table(name = "PASSENGER")
// @AttributeOverride(name = "user_id", column = @Column(name = "member_id"))
public class Passenger extends User implements IObserverService{
    //@OneToOne(cascade = CascadeType.ALL)
    //@Column
    @Transient
    private List<TicketFacade> tickets;

    @Column(name = "travel_points")
    int travelPoints;  
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subscription_id", nullable = false)
    Subscription subscription;

    // Member
    public Passenger(String name, String email, String password, int paymentPlan) {
        super(name, email, password, "ROLE_MEMBER");
        subscription = new Subscription(paymentPlan);
        tickets = new ArrayList<>();
        travelPoints = 0;
    }

    // Guest
    public Passenger(String name, String email) {
        super(name, email, null, "ROLE_GUEST");
        tickets = new ArrayList<>();
    }

    public int getTravelPoints() {
        return travelPoints;
    }

    public void setTravelPoints(int travelPoints) {
        this.travelPoints = travelPoints;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }
    
    public void bookTicket(TicketFacade t){
        tickets.add(t);
    }

    public TicketFacade viewTicket(TicketFacade t){
        return t;
    }

    public List<TicketFacade> viewAllTickets(){
        return tickets;
    }

    public void amendTicket(TicketFacade t){

    }

    public void calcDiscount(){
        
    }

    @Override
    public void update(StrikeReport rep) {
    tickets.clear();
    }

    public void payTicket(IPaymentStrategy paymentMethod, TicketFacade ticket) {
        paymentMethod.pay(ticket.getTicketPrice());
    }
    
}
