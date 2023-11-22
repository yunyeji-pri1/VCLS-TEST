package com.neonexsoft.vclstest.dao;

import com.neonexsoft.vclstest.dto.MemberDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Mapper
@Repository
public interface MemberDao {
    MemberDto getMemberinfo(String mbrId) throws SQLException;
}
