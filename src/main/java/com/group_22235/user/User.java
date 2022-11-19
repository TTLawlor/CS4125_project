package com.group_22235.user;

import java.util.ArrayList;
import java.util.List;

import com.group_22235.booking.Ticket;
import com.group_22235.staff.Observer;

public class User implements Observer{
    private String name;
    private String email;
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
