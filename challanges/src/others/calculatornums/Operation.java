package others.calculatornums;

import java.util.Arrays;

public class Operation {

	public ArithmeticOperation sum() {
		ArithmeticOperation doSum = (nums) -> {
			return Arrays.asList(nums)
			.stream()
			.reduce(0d, Double::sum);
		};
		return doSum;
	}	
	
	public ArithmeticOperation difference() {
		ArithmeticOperation doSubst = (nums) -> {
			return Arrays.asList(nums)
					.stream()
					.reduce(0d, (a,b) -> Math.abs(a - b));
		};
		return doSubst;
	}
	
	public ArithmeticOperation multiplication() {
		ArithmeticOperation doMulti = (nums) -> {
			return Arrays.asList(nums)
					.stream()
					.reduce(1d, (a,b) -> a * b);
		};
		return doMulti;
	}

}
