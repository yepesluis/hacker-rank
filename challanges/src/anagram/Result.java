package anagram;

import java.util.Map;
import java.util.stream.Collectors;

public class Result {
	
	 /*
     * Complete the 'anagram' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */
	
	// https://www.hackerrank.com/challenges/anagram/problem

    public static int anagram(String s) {
    	
    	int wordSize = s.length();
    	if(wordSize % 2 != 0) 
    		return -1;
    	
    	int halfWordSize = wordSize / 2;
    	
    	
    	String first = s.substring(0,halfWordSize);
    	Map<Character, Integer> firstMap = first.chars().mapToObj(c -> (char) c)
    			.collect(Collectors.groupingBy(character -> character, Collectors.summingInt(character -> 1)));
    	
    	String second = s.substring(halfWordSize);
    	Map<Character, Integer> secondMap = second.chars().mapToObj(c -> (char) c)
    			.collect(Collectors.groupingBy(character -> character, Collectors.summingInt(character -> 1)));
    	
    	int changesNeed = 0;
    	for (Map.Entry<Character, Integer> entry : firstMap.entrySet()) {
    		char key = entry.getKey();
    		int value = entry.getValue();
    		int secondCount = secondMap.getOrDefault(key, 0);
    		if(value > secondCount) {
    			changesNeed += value - secondCount;
    		} 
    	}

    	return changesNeed;	
    	
    }

}
