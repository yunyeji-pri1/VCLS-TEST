package com.neonexsoft.vclstest.error;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class CustomErrorController implements ErrorController{
	
	@RequestMapping(value = "/error")
	public ModelAndView handleError(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		log.info("===================== : " + status.toString());
		
		if(status != null) {
			int statusCode = Integer.valueOf(status.toString());
//			if(statusCode == HttpStatus.NOT_FOUND.value()) {
//				mv.addObject("aa", status);
//				mv.setViewName("/error/404");
//			}
			mv.addObject("aa", status);
			mv.setViewName("/error/404");
		}
		
		return mv;
	}
	
	
	
}
