package algorithms.discussions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a
 * pallindrome.
 * 
 * Return all possible pallindrome partitioning of s. Input: "aab" Output: [
 * ["aa","b"], ["a","a","b"] ]
 * 
 * @author SS057631
 *
 */
public class PallindromicPartitions {

	public static void main(String[] args) {
		System.out.println(getPallindromicPartitions("aabb"));
	}
	
	static List<List<String>> resultList = new ArrayList<List<String>>();
	public static List<List<String>> getPallindromicPartitions(String str) {
		//since we need to generate all the permutations, it looks like a backtracking problem
		//for each character we will calculate all the possibilities and backtrack once we reach the end
		recursionHelper(0, new ArrayList<String>(), str);
		return resultList;
	}

	private static void recursionHelper(int start, List<String> partitions, String str) {
		//stopping condition
		if(start >= str.length()) {
			resultList.add(new ArrayList<String>(partitions));
		}
		
		for(int end = start; end < str.length(); end++) {
			if(isPallindrome(str, start, end)) {
				String partition = str.substring(start, end+1);
				partitions.add(partition);
				recursionHelper(end + 1, partitions, str);
				partitions.remove(partitions.size() - 1);
			}
		}
	}

	private static boolean isPallindrome(String str, int start, int end) {
		while(start < end) {
			if(str.charAt(start) != str.charAt(end)) return false;
			start++;
			end--;
		}
		return true;
	}

}
