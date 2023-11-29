package com.neonexsoft.vclstest.security.entity;

import com.neonexsoft.vclstest.content.member.dto.MemberDto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.ArrayList;
import java.util.Collection;

@Getter
@Setter
public class Member extends org.springframework.security.core.userdetails.User{
    private MemberDto memberDto;

    public Member(MemberDto memberDto) {
        super(memberDto.getMbrId(), memberDto.getMbrPw(), getAuthorities(memberDto));
        SecurityContext context = SecurityContextHolder.getContext();
        context.setAuthentication(new UsernamePasswordAuthenticationToken(memberDto, memberDto.getMbrPw(), getAuthorities(memberDto)));
        this.memberDto = memberDto;
    }

    public static Collection<? extends GrantedAuthority> getAuthorities(MemberDto memberDto){
        Collection<GrantedAuthority> auth = new ArrayList<GrantedAuthority>();
//        if (user.getAuth().equals(UserRole.admin)) {
//            auth.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
//        } else {
//            auth.add(new SimpleGrantedAuthority("ROLE_USER"));
//        }

        auth.add(new SimpleGrantedAuthority("ROLE_USER"));
        return auth;
    }
}
