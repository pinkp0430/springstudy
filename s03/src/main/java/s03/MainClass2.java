package s03;

import org.springframework.context.support.*;

import s03.Calculator;
import s03.MyCalculator;

public class MainClass2 {

	public static void main(String[] args) {

		String configLocation = "classpath:applicationCTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);// 복사해서 써라
		
		MyCalculator myCalculator = ctx.getBean("myCalculator",MyCalculator.class);//스프링 프레임워크에서 만들고(스풀링까지 한다?)
		ctx.close();
				
		myCalculator.add();
		myCalculator.sub();
		myCalculator.mul();
		myCalculator.div();
		
	}

}
