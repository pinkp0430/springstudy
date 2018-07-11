package com.wind.sp06;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Mainclass {

	public static void main(String[] args) {

//		AnnotationConfigApplicationContext ctx 
//			= new AnnotationConfigApplicationContext(ApplicationConfig.class);
//		
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		
		Student student = ctx.getBean("student1",Student.class);
		
		System.out.println("이름 : " + student.getName());
		System.out.println("나이 : " + student.getAge());
		
		student = ctx.getBean("student2",Student.class);
		
		System.out.println("이름 : " + student.getName());
		System.out.println("나이 : " + student.getAge());
	
		Conan student3 = ctx.getBean("conan", Conan.class);
		student3.setName("코난");
		System.out.println("이름 : " + student3.getName());
	}
	
}
