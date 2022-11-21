package com.group_22235.user;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.group_22235.booking.Ticket;
import com.group_22235.generics.ABaseEntity;
import com.group_22235.staff.IObserverService;

@Entity
@Table(name = "USER")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@AttributeOverride(name = "id", column = @Column(name = "user_id"))
public class User extends ABaseEntity implements IObserverService{
    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Transient
    private List<Ticket> tickets;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
        tickets = new ArrayList<>();
    }

    

    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }



    public String getEmail() {
        return email;
    }



    public void setEmail(String email) {
        this.email = email;
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

    @Override
    public void updateStrike() {
        // Display msg to user on site that no train running and mock email user
        System.out.println("No trains running due to strike");
    }
    
}
