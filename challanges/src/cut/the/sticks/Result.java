package cut.the.sticks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Result {
	
	 /*
     * Complete the 'cutTheSticks' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
	
	//https://www.hackerrank.com/challenges/cut-the-sticks/problem

    public static List<Integer> cutTheSticks(List<Integer> arr) {
    
    	List<Integer> remainingSticks = new ArrayList<>();
    
    	/*option 1:
    	arr = arr.stream().sorted().collect(Collectors.toList());
    	while (arr.size() > 0) {
    		remainingSticks.add(arr.size());
    		var shortestStick = arr.get(0);
    		arr = arr.stream()
    				.map(x -> x - shortestStick)
    				.filter(x -> x != 0).collect(Collectors.toList());
    	}
    	*/
    	
    	//option 2, better:
    	
    	while (!arr.isEmpty()) { 
    		remainingSticks.add(arr.size()); 
    		int shortestStick = Collections.min(arr); 
    		arr = arr.stream() .map(x -> x - shortestStick)
    		 .filter(x -> x > 0)
    		 .collect(Collectors.toList());
    	}
    	
    	return remainingSticks;
    		
    }

}
