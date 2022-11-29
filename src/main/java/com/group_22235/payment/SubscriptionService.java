package com.group_22235.payment;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.group_22235.generics.ABaseServiceImpl;

@Service
@Transactional
public class SubscriptionService extends ABaseServiceImpl<Subscription, Long> implements ISubscriptionService{

    protected SubscriptionService(SubscriptionRepository abstractBaseRepository) {
        super(abstractBaseRepository);
    }
    
}
