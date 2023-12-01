package com.neonexsoft.vclstest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.neonexsoft.vclstest.dto.TestDto;
import com.neonexsoft.vclstest.service.TestService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class Controller {
	
	@Autowired
	TestService testservice;
	
	@RequestMapping(value = "/aa")
	public ModelAndView index(HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		log.info("=============Interceptor=============");
		
//		mv.addObject("mv",1111111);
		mv.setViewName("lat/new");
		return mv;
	}
	
	@RequestMapping(value = "/aaa/bbb.json", method= {RequestMethod.GET,RequestMethod.POST})
	public Map<String, Object> index(@RequestBody TestDto testdto , HttpServletRequest request) throws Exception {
		Map<String, Object> mv = new HashMap<String, Object>();
		List<TestDto> vo = testservice.listAll(testdto);
		
		mv.put("vo", vo);
		

		return mv;
	}

	
	
}
