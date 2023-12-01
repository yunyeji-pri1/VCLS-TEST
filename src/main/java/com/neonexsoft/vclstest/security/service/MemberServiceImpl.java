package com.neonexsoft.vclstest.security.service;

import com.neonexsoft.vclstest.security.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MembersService{

    @Autowired
    private MemberDetailsService memberDetailsService;

    @Override
    public void loginUser(String id, String password) throws Exception{
        Member member = (Member) memberDetailsService.loadUserByUsername(id);
        if(member==null) throw new UsernameNotFoundException("USER_NOT_FOUND");
//        todo 비밀번호 암호화처리
//        BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
//        if(!bCrypt.matches(password, member.getPassword())) throw new BadCredentialsException("Bad_credentials");
    }
}
