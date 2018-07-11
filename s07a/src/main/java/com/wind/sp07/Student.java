package com.wind.sp07;

import java.util.ArrayList;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public  class Student implements  InitializingBean, DisposableBean {

		// 이름, 나이, 취미, 키, 몸무게
		private String name;
		private int age;
			
		public Student(String name, int age) {
			super();
			this.name = name;
			this.age = age;
		}

		public String getName() { return name; }
		public int getAge() { return age; }
	
		public void setName(String name) { this.name = name; }
		public void setAge(int age) { this.age = age; }
			
		@Override
		public void destroy() throws Exception {
			System.out.println("destroy()");
		}

		@Override
		public void afterPropertiesSet() throws Exception {
			System.out.println("afterPropertiesSet()");
		}	
}


