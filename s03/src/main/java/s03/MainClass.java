package s03;

import s03.Calculator;
import s03.MyCalculator;

public class MainClass {

	public static void main(String[] args) {
		
		MyCalculator myCalculator = new MyCalculator();
		myCalculator.setCalculator(new Calculator());
		
		myCalculator.setFirstNum(30);
		myCalculator.setSecondNum(5);
		
		myCalculator.add();
		myCalculator.sub();
		myCalculator.mul();
		myCalculator.div();
		
	}

}
