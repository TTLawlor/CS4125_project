package com.group_22235.payment;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.group_22235.generics.ABaseServiceImpl;

@Service
@Transactional
public class PaypalService extends ABaseServiceImpl<APayment, Long> implements IPaymentService{

    protected PaypalService(PaypalRepository abstractBaseRepository) {
        super(abstractBaseRepository);
    }
    
}
