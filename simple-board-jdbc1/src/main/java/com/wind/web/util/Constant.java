package com.wind.web.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class Constant {
	
	@Autowired
	public static JdbcTemplate template; // 아무대서나 불러 쓰라고 static으로 셋
	

}
