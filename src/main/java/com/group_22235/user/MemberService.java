package com.group_22235.user;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.group_22235.generics.ABaseServiceImpl;

@Service
@Transactional
public class MemberService extends ABaseServiceImpl<Member, Long> implements IMemberService{
    
    public MemberService(MemberRepository mRepository) {
        super(mRepository);
    }
    

}
