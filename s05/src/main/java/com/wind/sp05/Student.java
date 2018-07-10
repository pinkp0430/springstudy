package com.wind.sp05;

public class Student {
	
	private String name;
	private String age;
	private String gradeNum;
	private String classNum;
	
	public Student(String name, String age, String gradeNum, String classNum) {//클래스가 처음 생성될때 사용되는 함수라 생각하셈
		super();
		this.name = name;
		this.age = age;
		this.gradeNum = gradeNum;
		this.classNum = classNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGradeNum() {
		return gradeNum;
	}

	public void setGradeNum(String gradeNum) {
		this.gradeNum = gradeNum;
	}

	public String getClassNum() {
		return classNum;
	}

	public void setClassNum(String classNum) {
		this.classNum = classNum;
	}
	
}
