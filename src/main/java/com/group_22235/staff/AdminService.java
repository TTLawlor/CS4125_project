package com.group_22235.staff;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.group_22235.generics.ABaseServiceImpl;

@Service
@Transactional
public class AdminService extends ABaseServiceImpl<Admin, Long> implements IAdminService{

    public AdminService(AdminRepository aRepository) {
        super(aRepository);
    }

}
