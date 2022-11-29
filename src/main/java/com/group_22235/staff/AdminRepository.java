package com.group_22235.staff;

import org.springframework.stereotype.Repository;

import com.group_22235.generics.IBaseRepository;

@Repository
public interface AdminRepository extends IBaseRepository<Admin, Long>{
    
}
