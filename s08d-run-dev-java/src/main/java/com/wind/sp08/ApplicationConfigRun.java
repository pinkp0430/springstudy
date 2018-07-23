package com.wind.sp08;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.*;

@Configuration
@Profile("run")
public class ApplicationConfigRun {
	
	@Bean
	public ServerInfo serverInfo() {
	
		ServerInfo info = new ServerInfo();
		info.setIpNum("211.25.45.128");
		info.setPortNum("80");
		return info;

	}

}
