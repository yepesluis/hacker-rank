package disk.space.analysis.jobsity;

import java.util.List;

public class Result {
	
    /*
     * Complete the 'segment' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER x -  segment length to analyze
     *  2. INTEGER spaceCount - n
     *  3. INTEGER_ARRAY space
     */

    public static int segment(int x, int spaceCount, List<Integer> space) {		

    	int maxValue = 1;	
    	
		int i = 0;
		int lastPos =  x;
		while(i < spaceCount && lastPos <= spaceCount) {	
			maxValue = getMaxValue(space.subList(i, lastPos), maxValue);
			i = i + 1;
			lastPos = lastPos + 1;
		}
		int missingPartners = spaceCount % x;
		if (missingPartners !=0) {
			int initialPos = spaceCount-x;
			maxValue = getMaxValue(space.subList(initialPos, spaceCount), maxValue);
    	}
		return maxValue;	
    }

	private static int getMaxValue(List<Integer> subSpace, int maxValue) {
		int minimum = subSpace.stream()
				.mapToInt(Integer::intValue)
				.min()
				.getAsInt();
		if (minimum > maxValue) {
			return minimum;
		} 
		return maxValue;
	}

}
