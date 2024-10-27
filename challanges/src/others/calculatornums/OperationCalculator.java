package others.calculatornums;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OperationCalculator {
	
	public static void main(String args[]) {
		
		List<Double> nums = new ArrayList<>();
		Scanner scan = new Scanner(System.in);
		String operation = "";
		
		System.out.println("insert numbers separated by enter or type operation name to execute it");
		 while(operation.isBlank()) {
			if(scan.hasNextDouble()) {
				nums.add(scan.nextDouble());
			} else {
				operation = scan.next();
			}
		}
		 scan.close();
		 
		 System.out.println("operation " + operation 
				 + " result: " + operateByOperationName(operation, nums.toArray(new Double[0])));
		
	}
	
	static Double operateByOperationName(String operationName, Double...nums) {
		return switch(operationName) {
		case "sum" -> calculateOperation(new Operation().sum(), nums);
		case "difference" -> calculateOperation(new Operation().difference(), nums);
		case "multiplication" -> calculateOperation(new Operation().multiplication(), nums);
		default -> throw new IllegalArgumentException("Unexpected value: " + operationName);
		};
		
	}
	
	static Double calculateOperation(ArithmeticOperation arithmeticOperation, Double...nums) {
		return arithmeticOperation.operate(nums);
	}
	

}
