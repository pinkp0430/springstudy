package com.wind.sp08;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Mainclass {

	public static void main(String[] args) {

		String config = null;
		Scanner scanner = new Scanner(System.in);
		String str = scanner.next();
		
		if(str.equals("dev")) {
			config = "dev";
		} else if(str.equals("run")) {
			config = "run";
		}
		
		scanner.close();
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.getEnvironment().setActiveProfiles(config);
		ctx.load("classpath:applicationCTX_dev.xml","classpath:applicationCTX_run.xml");
		
		ServerInfo serverInfo = ctx.getBean("serverInfo",ServerInfo.class);
		System.out.println("ip : " + serverInfo.getIpNum());
		System.out.println("port : " + serverInfo.getPortNum());
		ctx.close();
		
	}

}
