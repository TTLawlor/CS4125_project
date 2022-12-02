package com.group_22235.payment;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.group_22235.user.Passenger;

@SpringBootTest
public class IPaymentStrategyTest {

    @Test
    void should_pay_by_credit_card() {
        String cardType = "Visa Debit";
        String cardName = "John Doe";
        String cardNumber = "123412341234";
        String expiryDate = "01/23";
        int cvv = 123;
        APayment payment = new CreditCardStrategy(cardType, cardName, cardNumber, expiryDate, cvv);
        IPaymentStrategy paymentStrategy = payment;
        Passenger member = new Passenger(cardName, "johndoe@gmail.com", "password", 3);

        Date current = member.getSubscription().getRenewalDate();
        Calendar cal = Calendar.getInstance();
        cal.setTime(current);
        cal.add(Calendar.MONTH, 3);
        current = cal.getTime();
        member.getSubscription().paySubscription(paymentStrategy);

        assertEquals(current.toString(), member.getSubscription().getRenewalDate().toString());

    }

    @Test
    void should_pay_by_paypal() {
        String cardName = "John Doe";
        String email = "johndoe@gmail.com";
        String password = "password";
        APayment payment = new PaypalStrategy(email, password);
        IPaymentStrategy paymentStrategy = payment;
        Passenger member = new Passenger(cardName, "johndoe@gmail.com", "password", 3);

        Date current = member.getSubscription().getRenewalDate();
        Calendar cal = Calendar.getInstance();
        cal.setTime(current);
        cal.add(Calendar.MONTH, 3);
        current = cal.getTime();
        member.getSubscription().paySubscription(paymentStrategy);

        assertEquals(current.toString(), member.getSubscription().getRenewalDate().toString());

    }

}
