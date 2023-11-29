package com.neonexsoft.vclstest;

import com.neonexsoft.vclstest.content.member.dao.MemberDao;
import com.neonexsoft.vclstest.content.member.dto.MemberDto;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class AuthServiceTest {
    private static final Logger logger = LoggerFactory.getLogger(AuthServiceTest.class);
//
//    @Autowired
//    private MemberDao memberDao;
//
//
//    // 토큰생성
//    @Test
//    public void makeToken(){
//        logger.info("Request create jwt token");
//        Map<String, String> result = new HashMap<>();
//
//        try {
//            result.put("isError", "N");
//            System.out.println(memberDao.getMemberinfo("TEST"));
//            MemberDto memberDto = null;
//            memberDto = memberDao.getMemberinfo("TEST");
////            입력받은 email, password 로 UsernamePasswordAuthenticationToken 생성
//            UsernamePasswordAuthenticationToken authenticationToken =
//                    new UsernamePasswordAuthenticationToken(memberDto.getMbrId(), memberDto.getMbrPw());
//        } catch (Exception e) {
//            result.put("isError", "Y");
//            logger.error("Fail to create jwt token");
//        }
//
//    }

    public void login(){
//        TestDto user = new TestDto(1, "aaa", "테스트", "testDate");


    }

}
