package com.group_22235.user;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.group_22235.payment.IPaymentStrategy;
import com.group_22235.payment.Subscription;

@Entity
@Table(name = "MEMBER")
// @AttributeOverride(name = "user_id", column = @Column(name = "member_id"))
public class Member extends User {
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id", nullable = false)
    Account acc;

    @Column(name = "travel_points")
    int travelPoints;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subscription_id", nullable = false)
    Subscription subscription;

    public Member(String name, String email, String password, int paymentPlan) {
        super(name, email);
        acc = new Account(password, false);
        subscription = new Subscription(paymentPlan);
    }

    public void calcDiscount(){

    }
    
    public void paySubscription(IPaymentStrategy paymentMethod){
		double amount = subscription.getCost();
		paymentMethod.pay(amount);

        Date oldRenewal = subscription.getRenewalDate();
        Calendar cal = Calendar.getInstance();
        cal.setTime(oldRenewal);
        cal.add(Calendar.MONTH, subscription.getPaymentPlan());
        subscription.setRenewalDate(cal.getTime());
	}

}
