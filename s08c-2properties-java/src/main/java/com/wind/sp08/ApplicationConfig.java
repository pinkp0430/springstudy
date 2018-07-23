package com.wind.sp08;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@Configuration
public class ApplicationConfig {
	
	@Value("${admin.id}") //스프링이 아래의 프로퍼티들의 값을 가져다 각각의 값을 넣는다.
	private String adminId;
	@Value("${admin.pw}")
	private String adminPw;
	@Value("${sub_admin.id}")
	private String sub_adminId;
	@Value("${sub_admin.pw}")
	private String sub_adminPw;

	@Bean
	public static PropertySourcesPlaceholderConfigurer properties() { //메모리에 객체로 올리는 게 아니라 야만의 공간(static)에 실행되어 올라가 있으므로 스프링이 이 properties의 값을 가지고 있다.
																		// 이 메소드의 역활이 저번에 코딩햇던 applicationCTX.xml의
																		//<context:property-placeholder location="classpath:admin.properties,classpath:sub_admin.properties"/>
																		//와 같은 역할이당... 
		PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
		
		Resource[] locations = new Resource[2];
		locations[0] = new ClassPathResource("admin.properties");
		locations[1] = new ClassPathResource("sub_admin.properties");
		
		configurer.setLocations(locations);
		
		return configurer;
	}

	@Bean
	public AdminConnection adminConfig() {
		
		AdminConnection adminConnection = new AdminConnection();
		adminConnection.setAdminId(adminId);
		adminConnection.setAdminPw(adminPw);
		adminConnection.setSub_adminId(sub_adminId);
		adminConnection.setSub_adminPw(sub_adminPw);
		
		return adminConnection;
	}
}

