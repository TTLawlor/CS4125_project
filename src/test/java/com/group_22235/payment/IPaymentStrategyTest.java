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

        member.pay(paymentStrategy, "SUBSCRIPTION");

        Date current = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(current);
        cal.add(Calendar.MONTH, 6);
        current = cal.getTime();

        assertEquals(current.toString(), member.getSubscription().getRenewalDate().toString());

    }
}
