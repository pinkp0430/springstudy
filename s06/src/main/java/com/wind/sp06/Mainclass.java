package com.wind.sp06;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Mainclass {

	public static void main(String[] args) {
//		String configLocation1 = "classpath:applicationCTX1.xml";
		String configLocation2 = "classpath:applicationCTX2.xml";
//		
//		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation1, configLocation2);
	
		AnnotationConfigApplicationContext ctx 
			= new AnnotationConfigApplicationContext(ApplicationCTX.class);
		Student student1 = ctx.getBean("student1", Student.class);
		
		System.out.println("The Name of student1 is : "+student1.getName()); // student1의 이름이 나옴
		System.out.println(student1.getHobbies());
		
		StudentInfo studentInfo = ctx.getBean("studentInfo1", StudentInfo.class); // student1이 들어간 studentInfo1의 정보를 가져온다
		
		Student student3 = studentInfo.getStudent();	// studentInfo1의 정보를 student3에 넣는다.
		System.out.println("The Name of student3 is : "+student3.getName());	// student3의 이름이 나옴 == student1
		System.out.println(student3.getHobbies());
		
		if(student1.equals(student3)) {
			System.out.println("student1 == student3");
		}
		
//		AbstractApplicationContext ctx1 = new GenericXmlApplicationContext(configLocation2);
//		Student student2 = ctx1.getBean("student2", Student.class); // applicationCTX2에서 만들어진
		
		Student student2 = ctx.getBean("student2", Student.class); // applicationCTX2에서 만들어진
		System.out.println("The Name of student2 is : "+student2.getName());
		
		if(student1.equals(student2)) {
			System.out.println("student1 == student2");
		} else {
			System.out.println("student1 != student2");
		}	
	}
}