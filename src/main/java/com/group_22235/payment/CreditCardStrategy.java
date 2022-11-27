package com.group_22235.payment;


import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "CREDIT_CARD")
public class CreditCardStrategy extends APayment{

    @Column
    private String cardType;
    @Column
    private String cardName;
    @Column
    private String cardNumber;
    @Column
    private String expiryDate;
    @Column
    private int cvv;

    public CreditCardStrategy(String cardType, String cardName, String cardNumber, String expiryDate, int cvv) {
        this.cardType = cardType;
        this.cardName = cardName;
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }

    @Override
    public void pay(double amount) {
        System.out.println(amount +" paid with " + cardType + " card");
    }
    
}
