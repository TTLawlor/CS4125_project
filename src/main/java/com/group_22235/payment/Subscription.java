package com.group_22235.payment;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.group_22235.generics.ABaseEntity;

@Entity
@Table(name = "SUBSCRIPTION")
@AttributeOverride(name = "id", column = @Column(name = "subscription_id"))
public class Subscription extends ABaseEntity{
    
    @Column
    private double cost;
    @Column
    private int paymentPlan;
    @Column
    private Date renewalDate;

    public Subscription(int paymentPlan) {
        this.paymentPlan = paymentPlan;
        cost = calcCost(paymentPlan);
        renewalDate = calcRenewalDate(paymentPlan);
    }

    private Date calcRenewalDate(int paymentPlan) {
        Date current = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(current);

        switch (paymentPlan) {
            case 3:
                cal.add(Calendar.MONTH, 3);
                break;
            case 6:
                cal.add(Calendar.MONTH, 6);
                break;
            case 12:
                cal.add(Calendar.MONTH, 12);
                break;
            default:
                System.out.println("Error occured, please try again");
        }

        current = cal.getTime();
        return current;
    }

    private double calcCost(int paymentPlan) {
        switch (paymentPlan) {
            case 3:
                cost = 15;
                break;
            case 6:
                cost = 25;
                break;
            case 12:
                cost = 45;
                break;
            default:
                System.out.println("Error occured, please try again");
        }
        return cost;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getPaymentPlan() {
        return paymentPlan;
    }

    public void setPaymentPlan(int paymentPlan) {
        this.paymentPlan = paymentPlan;
    }

    public Date getRenewalDate() {
        return renewalDate;
    }

    public void setRenewalDate(Date renewalDate) {
        this.renewalDate = renewalDate;
    }
    
}
