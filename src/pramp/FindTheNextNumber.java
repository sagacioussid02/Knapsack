package pramp;

import java.util.ArrayList;
import java.util.List;

//find the nth number in the series 5,10,19...
public class FindTheNextNumber {

	static List<Integer> storedNums = new ArrayList<Integer>();
	public static void main(String[] args) {
		System.out.println(findNextNumber(5,new int[] {5,10,19,32}));
	}
	
	public static int findNextNumber(final int n, final int[] ar) {
		if(ar != null && storedNums.size() > n) return storedNums.get(n);
		for(int entry:ar) storedNums.add(entry);
		int length = ar.length;
		int first = ar[length - 1];
		int second = ar[length - 2];
		for(int i = length; i <= n; i++) {
			int newNum = (2 * first) - second + 4;
			storedNums.add(newNum);
			second = first;
			first = newNum;
		}
		return storedNums.get(n - 1);
	}

}
