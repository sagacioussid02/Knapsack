package code.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class Java8BiFunction {
	
	private static final Map<String, BiFunction<Integer, Integer, Integer>> OPERATIONS = new HashMap<>();
	
	static {
		
	}

	public static void main(String[] args) {
		OPERATIONS.put("+", (a, b) -> a + b);
		System.out.println(OPERATIONS.get("+").apply(4, 5));
	}

}
