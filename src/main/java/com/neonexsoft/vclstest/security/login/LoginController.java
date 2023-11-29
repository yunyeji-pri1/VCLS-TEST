package com.neonexsoft.vclstest.security.login;

import com.neonexsoft.vclstest.security.config.ErrorCode;
import com.neonexsoft.vclstest.security.entity.RequestLoginUser;
import com.neonexsoft.vclstest.security.service.MemberServiceImpl;
import io.jsonwebtoken.ExpiredJwtException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private MemberServiceImpl memberService;


    @GetMapping(path = { "","/login"})
    public ModelAndView dispLogin(HttpServletRequest req) {
        ModelAndView mav = new ModelAndView("/login/login");
        return mav;
    }

    @PostMapping("/login")
    public ModelAndView login(RequestLoginUser user, HttpServletRequest req, HttpServletResponse res) {
        logger.info("Request login: " + user.getId());
        ModelAndView mav = new ModelAndView("login/login");
        String errorMsg = "";
        try {
            memberService.loginUser(user.getId(), user.getPassword());
            return new ModelAndView("/dashboard/liveDashboard");    //redirect 재확인필요
        } catch (Exception e) {
            e.printStackTrace();
            if(e.getMessage().equals(ErrorCode.TOKEN_EXPIRED.toString())) {
                errorMsg = ErrorCode.TOKEN_EXPIRED.toString();
            }
            if(e instanceof ExpiredJwtException) {
                errorMsg = ErrorCode.TOKEN_EXPIRED.toString();
            }
            if(e instanceof UsernameNotFoundException){
                errorMsg = ErrorCode.USER_NOT_FOUND.toString();
            }
            if(e instanceof BadCredentialsException){
                errorMsg = ErrorCode.Bad_credentials.toString();
            }
            mav.addObject("errorMsg", errorMsg);
        }
        return mav;
    }
}
