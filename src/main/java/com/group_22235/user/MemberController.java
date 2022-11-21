package com.group_22235.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.group_22235.generics.AController;
import com.group_22235.generics.IBaseController;

@RestController
public class MemberController extends AController<Member, Long> implements IBaseController<Member, Long>{
    
    @Autowired
    public MemberController(MemberService baseService) {
        super(baseService);
    }

    @Override
    @RequestMapping(method = RequestMethod.GET, value = "/member/{id}")
    public Member getByID(Long id) throws Exception {
        return super.getByID(id);
    }

    @Override
    @RequestMapping(method = RequestMethod.GET, value = "/members")
    public List<Member> getAll() throws Exception {
        return super.getAll();
    }

    @Override
    public void delete(Member entity) {
        super.delete(entity);
    }

    @Override
    public void deleteByID(Long id) {
        super.deleteByID(id);
    }
    
}
