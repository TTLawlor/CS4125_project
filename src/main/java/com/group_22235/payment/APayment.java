package com.group_22235.payment;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.group_22235.generics.ABaseEntity;

@Entity
@Table(name = "PAYMENT")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
    name = "PAYMENT_TYPE",
    discriminatorType = DiscriminatorType.STRING
)
@AttributeOverride(name = "id", column = @Column(name = "payment_id"))
public abstract class APayment extends ABaseEntity implements IPaymentStrategy{
    
    @Column
    private String billingName;
    
    @Column
    private String billingAdress;

    public String getBillingName() {
        return billingName;
    }
    public void setBillingName(String billingName) {
        this.billingName = billingName;
    }
    public String getBillingAdress() {
        return billingAdress;
    }
    public void setBillingAdress(String billingAdress) {
        this.billingAdress = billingAdress;
    }
    
}
