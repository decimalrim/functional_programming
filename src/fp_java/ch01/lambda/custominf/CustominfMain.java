package fp_java.ch01.lambda.custominf;

public class CustominfMain {
	
	public static void main(String[] args) {
		
		// Airline
			// public int getFee(int personCount);
		Airline airline = (personCount) -> personCount * Airline.ADULT_FEE;
		int fee = airline.getFee(7);
		System.out.println(fee);
		
		
		// Calculatable
			// public void printAddResult(int number1, int number2);
		Calculatable cal = (int number1, int number2) -> System.out.println(number1 + number2);
		cal.printAddResult(1, 10);
		
		Calculatable cal2 = (int number1, int number2) -> System.out.println(number1 - number2);
		cal2.printSubResult(10, 1);
		
		Calculatable cal3 = (int number1, int number2) -> System.out.println(number1 * number2);
		cal3.printMulResult(10, 1);
		
		Calculatable cal4 = (int number1, int number2) -> System.out.println(number1 / number2);
		cal4.printDivResult(6, 2);
		
	}
}
