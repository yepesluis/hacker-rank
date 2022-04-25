package plus.minus;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Result {
	
    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(int arrSize, List<Integer> arr) throws InterruptedException {
    // Write your code here
    		DecimalFormat dfZero = new DecimalFormat("0.000000");
    		
    		ExecutorService executor = Executors.newWorkStealingPool();
    		
        	List<Callable<String>> callables = Arrays.asList(
        			() -> {
        				long positiveValues = arr.stream().filter(x -> x > 0).count();
	        			double positiveRatio = (double) positiveValues/arrSize;
	                	return dfZero.format(positiveRatio);
	                	},
            		() -> {
        				long negativeValues = arr.stream().filter(x -> x < 0).count();
        				double negativeRatio =  (double) negativeValues/arrSize;
                		return dfZero.format(negativeRatio);
    					},
        			() -> {
        				long zeroValues = arr.stream().filter(x -> x == 0).count();
        				double zeroRatio =  (double) zeroValues/arrSize;
                		return dfZero.format(zeroRatio);
        				});
    		
        	executor.invokeAll(callables)
        	.stream()
        	.map(future -> {
        		try {
        			return future.get();
        		} catch (Exception e) {
        			throw new IllegalStateException(e);
        		}
        	})
        	.forEach(System.out::println);  		
 	
    }

}
