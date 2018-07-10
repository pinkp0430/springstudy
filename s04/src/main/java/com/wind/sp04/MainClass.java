package com.wind.sp04;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {

		String configLocation = "classpath:applicationCTX.xml"; // 변수에 오른쪽 스트링 주소를 넣는다
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation); //위의 xml을 찾아 객체를 만들어 ctx로 넘긴다.
		MyInfo myInfo = ctx.getBean("myInfo", MyInfo.class); //
		ctx.close();// 메인이 끝나면 닫힌다. 벗.. 메인이 무한루프라면 에러발생가능성 잇으므로 닫아라~
		
		myInfo.getInfo();
	}

}
