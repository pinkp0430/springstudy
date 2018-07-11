package com.wind.sp06;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Mainclass {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class); //스프링 컨테이너 안에 생성
		
		Student student1 = ctx.getBean("student1",Student.class);
		System.out.println("이름 : " + student1.getName());
		
		Student student2 = ctx.getBean("student2",Student.class);
		System.out.println("이름 : " + student2.getName());
	}

}
