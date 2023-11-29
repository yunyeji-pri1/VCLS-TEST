package com.neonexsoft.vclstest.content.member.service;

import com.neonexsoft.vclstest.content.member.dao.MemberDao;
import com.neonexsoft.vclstest.content.member.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class MemberService {
    @Autowired
    private final MemberDao memberDao;

    public MemberDto getMemberInfo(String id) throws Exception{
        MemberDto memberDto = memberDao.getMemberInfo(id);
        memberDto.setMbrId(memberDto.getMbrId());
        memberDto.setMbrPw(memberDto.getMbrPw());
        return memberDto;
    }
}
