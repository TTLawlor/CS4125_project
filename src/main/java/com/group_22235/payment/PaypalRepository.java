package com.group_22235.payment;

import org.springframework.stereotype.Repository;

import com.group_22235.generics.IBaseRepository;

@Repository
public interface PaypalRepository extends IBaseRepository<APayment, Long>{
    
}
