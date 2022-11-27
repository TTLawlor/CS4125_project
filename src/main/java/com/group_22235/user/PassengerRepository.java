package com.group_22235.user;

import org.springframework.stereotype.Repository;

import com.group_22235.generics.IBaseRepository;

@Repository
public interface PassengerRepository extends IBaseRepository<Passenger, Long>{
    
}
