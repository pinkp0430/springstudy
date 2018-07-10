package com.wind.sp03;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MaingClass {

	public static void main(String[] args) {
//		MyCalculator myCalculator = new MyCalculator();
		String configLocation = "classpath:applicationCTX.xml";//빈을 값을 포함해서 만들어달라
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
		MyCalculator myCalculator = ctx.getBean("myCalculator", MyCalculator.class);// 빈을 얻어서 myCalculator에 주소를 넣엇다
		ctx.close();
		
		myCalculator.add();
		myCalculator.sub();
		myCalculator.mul();
		myCalculator.div();
	
	}

}
