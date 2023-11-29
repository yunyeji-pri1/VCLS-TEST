package com.neonexsoft.vclstest.content.member.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberDto {
    private String username;

    private int mbrInfoKey;
    private int deptKey;
    private int coKey;
    private String mbrPw;
//    private String mbrNm;
    private String mbrBrdt;
    private String mbrCi;
    private String mbrCd;
    private String mbrIp;
    private String authrtCd;
    private String mbrAddr;
    private String rgtrNm;
    private String regYmdt;
    private String mdfrNm;
    private String mbrId;
    private String mdfcnYmdt;

}



