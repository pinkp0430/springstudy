package com.wind.sp07;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Mainclass {

	public static void main(String[] args) {

		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		
		Student student1 = ctx.getBean("student",Student.class); //student를 student1에 넣어 프린트
		System.out.println("이름 : " + student1.getName());
		System.out.println("나이 : " + student1.getAge());

		Student student2 = ctx.getBean("student",Student.class);	//student를 student2에 넣은 후
		student2.setName("햅번");										//student1의 이름을 바꿔서 출력
		System.out.println("이름 : " + student2.getName());		//오~ student1의 이름이 바뀐다. student1==student2는 같은 저장소
		System.out.println("나이 : " + student2.getAge());
		
		if(student1.equals(student2)) {
			System.out.println(student1 == student2);
		}else
			System.out.println(student1 != student2);
		
		Student act1 = ctx.getBean("act",Student.class);	//act를 act1에 넣어 프린트
		System.out.println("이름 : " + act1.getName());
		System.out.println("나이 : " + act1.getAge());
			
		Student act2 = ctx.getBean("act",Student.class);	//act를 act2에 넣은 후 
		act1.setName("아리랑");								//act1에 다른 이름을 넣고 출력
		System.out.println("이름 : " + act2.getName());		//act2는 걍 act에서 가져온 이름을 출력. act1 != act2는 다른 저장소(객체)
		System.out.println("나이 : " + act2.getAge());
		
		if(act1.equals(act2)) {
			System.out.println(act1 == act2);
		} else {
			System.out.println(act1 != act2);
		}
	}

}
