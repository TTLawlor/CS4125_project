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

import com.group_22235.booking.Ticket;
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
    private List<Ticket> tickets;

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
    
// public void bookTicket(Customer info){
    //     Ticket newTicket = new Ticket();
    //     tickets.add(newTicket);
    // }

    public Ticket viewTicket(Ticket t){
        return t;
    }

    public List<Ticket> viewAllTickets(){
        return tickets;
    }

    public void amendTicket(Ticket t){

    }

    public void calcDiscount(){
        
    }

    @Override
    public void update(StrikeReport rep) {
        // Check through tickets and see if any routes affected for dates listed
        // If so, would send an email to user, will mock by simply printing a String that would sent

        //String msg = String.format("Strike Notice. Your booking for the %t from %s to %s has been cancelled. The reason is %s. We are sorry for the inconvienece caused", );
    }

    public void pay(IPaymentStrategy paymentMethod, String purchase) {
        switch (purchase) {
            case "TICKET":
                break;
            case "SUBSCRIPTION":
                subscription.paySubscription(paymentMethod);
                break;
            default:
                throw new IllegalArgumentException("Invalid paymentMethod or purchase item");
        } 
    }
    
}
