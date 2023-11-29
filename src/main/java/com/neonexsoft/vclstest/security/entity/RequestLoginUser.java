package com.neonexsoft.vclstest.security.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
public class RequestLoginUser {

	private String id;
	private String password;
}
