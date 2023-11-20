package com.neonexsoft.vclstest.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.neonexsoft.vclstest.dto.TestDto;

@Mapper
@Repository
public interface TestDao {
	List<TestDto> listAll(TestDto td) throws SQLException;
 }
