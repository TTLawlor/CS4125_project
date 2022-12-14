package com.group_22235.user;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.group_22235.generics.IBaseRepository;

@Repository
public interface UserRepository extends IBaseRepository<User, Long>{
    // acts as unique identifier for account
    Optional<User> findByEmail(String email);
}
