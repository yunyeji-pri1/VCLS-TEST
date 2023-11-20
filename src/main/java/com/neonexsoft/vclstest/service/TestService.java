package com.neonexsoft.vclstest.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neonexsoft.vclstest.dao.TestDao;
import com.neonexsoft.vclstest.dto.TestDto;

@Service
public class TestService {
	
	@Autowired
	private TestDao testdao;
	
	public List<TestDto> listAll(TestDto testdto) throws Exception{
		List<TestDto> aa = testdao.listAll(testdto);
		
		return aa;
	}
}
