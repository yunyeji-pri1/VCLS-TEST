package com.neonexsoft.vclstest.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class Controller {
	
	@RequestMapping(value = "/aaa")
	public ModelAndView index(HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView();
		
//		mv.addObject("mv",1111111);
//		mv.setViewName("index");
		mv.setViewName("lat/new");
		return mv;
	}
	
}
