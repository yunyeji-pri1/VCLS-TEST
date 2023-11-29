package com.neonexsoft.vclstest.security.service;

import com.neonexsoft.vclstest.content.member.dao.MemberDao;
import com.neonexsoft.vclstest.content.member.dto.MemberDto;
import com.neonexsoft.vclstest.security.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

/**
 * 실제 DB 에서 값을 조회 하여 UserDetails 타입 리턴 하는 서비스
 */
@Service
@RequiredArgsConstructor
public class MemberDetailsService implements UserDetailsService {

    private final MemberDao memberDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MemberDto memberDto = null;

        try {
            memberDto = memberDAO.getMemberInfo(username);
            memberDto.setMbrId(memberDto.getMbrId());
            memberDto.setMbrPw(memberDto.getMbrPw());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(memberDto == null) {
            throw new UsernameNotFoundException("아이디:"+username+"를 찾을 수 없습니다.");
        }

        return new Member(memberDto);
    }
}
