package fizzbuzz;

import java.util.stream.IntStream;

public class Result {
	
    /*
     * Complete the 'fizzBuzz' function below.
     *
     * The function accepts INTEGER n as parameter.
     */

    public static void fizzBuzz(int n) {
    	
    	IntStream.rangeClosed(1, n)
    	.forEach(x -> {
    		if(x % 5 == 0 && x % 3 == 0) {
    			System.out.println("FizzBuzz");
    		} else if (x % 5 != 0 && x % 3 == 0) {
    			System.out.println("Fizz");
    		} else if (x % 5 == 0 && x % 3 != 0) {
    			System.out.println("Buzz");
    		} else {
    			System.out.println(x);
    		}
    	});

    }

}
