package com.neonexsoft.vclstest.content.member.dao;

import com.neonexsoft.vclstest.content.member.dto.MemberDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

@Repository
@Mapper
public interface MemberDao {
    MemberDto getMemberInfo(String mbrId) throws SQLException;
}
