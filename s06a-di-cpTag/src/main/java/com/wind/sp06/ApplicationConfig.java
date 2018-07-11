package com.wind.sp06;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
	
	@Bean
	public Family family() {
		
		Family family = new Family("더스틴 호프만","메릴 스트립");
		family.setBrotherName("빌리");
		
		return family;
	}
	

}
