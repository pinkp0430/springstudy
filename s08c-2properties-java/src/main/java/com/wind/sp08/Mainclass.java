package com.wind.sp08;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Mainclass {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		AdminConnection adminConnection = ctx.getBean("adminConfig",AdminConnection.class);
		
		System.out.println("adminID : " + adminConnection.getAdminId());
		System.out.println("adminPW : " + adminConnection.getAdminPw());
		System.out.println("sub_adminID : " + adminConnection.getSub_adminId());
		System.out.println("sub_adminPW : " + adminConnection.getSub_adminPw());
		
		ctx.close();
	}

}
