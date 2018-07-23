package com.wind.sp08;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Mainclass {

	public static void main(String[] args) {

		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		
		AdminConnection adminConnection = ctx.getBean("adminConnection",AdminConnection.class);
		
		System.out.println(adminConnection.getAdminId());
		System.out.println(adminConnection.getAdminPw());
		System.out.println(adminConnection.getSub_adminId());
		System.out.println(adminConnection.getSub_adminPw());
		
		ctx.close();
	}

}
