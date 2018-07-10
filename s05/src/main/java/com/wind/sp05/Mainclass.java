package com.wind.sp05;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Mainclass {

	public static void main(String[] args) {

		String configLocation = "classpath:applicationCTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
		StudentInfo studentInfo = ctx.getBean("studentInfo",StudentInfo.class);//student1의 정보를 출력
		
		studentInfo.getStudentInfo();

		Student student2 = ctx.getBean("student2",Student.class);//student2의 정보를 studnet2에 넣고
		studentInfo.setStudent(student2);//studentInfo에 넣어
		studentInfo.getStudentInfo();//studentInfo를 출력
		
		ctx.close();
		
	}

}
