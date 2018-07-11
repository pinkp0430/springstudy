package com.wind.sp06;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationCTX {

	@Bean
	public Student student1() {
		
		ArrayList<String> hobbies = new ArrayList();
		hobbies.add("수영");
		hobbies.add("요리");
		
		Student student1 = new Student("그레고리팩",34, hobbies);
		student1.setHeight(175);
		student1.setWeight(77);
		
		return student1;
	}
	
	@Bean
	public StudentInfo studentInfo1() {
		
		StudentInfo studentInfo1 = new StudentInfo();
		studentInfo1.setStudent(student1());
		
		return studentInfo1;
	}
	
	@Bean
	public Student student2() {
		
		ArrayList<String> hobbies = new ArrayList();
		hobbies.add("마술");
		hobbies.add("도둑질");
		
		Student student2 = new Student("루팡",34, hobbies);
		student2.setHeight(175);
		student2.setWeight(65);
		
		return student2;
	}
}
