package algorithms.discussions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Find all valid combinations of k numbers that sum up to n such that the
 * following conditions are true:
 * 
 * Only numbers 1 through 9 are used. Each number is used at most once. Return a
 * list of all possible valid combinations. The list must not contain the same
 * combination twice, and the combinations may be returned in any order.
 * 
 * @author SS057631
 *
 */
public class CombinationSum3 {
	
	public static List<List<Integer>> combinationSum3(int[] candidates, int target, int k) {
		//since we need to form an array whose target sum is given we need to dynamically
		//add or remove elements from the array which ill require backtracking
		Set<List<Integer>> resultList = new HashSet<List<Integer>>();
		List<Integer> internalList = new ArrayList<Integer>();
		Arrays.sort(candidates);
		backtrackingRecursionHelper(-1,candidates, target, target, resultList, internalList, k);
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		results.addAll(resultList);
		return results;
	}

	private static void backtrackingRecursionHelper(int pos, int[] candidates, int sumSoFar, int target,
			Set<List<Integer>> resultList, List<Integer> internalList, int k) {
		//stopping condition
		if(pos > candidates.length - 1 || sumSoFar < 0) return;
		if(sumSoFar == 0) {
			if(internalList.size() == k) {
				resultList.add(new ArrayList<Integer>(internalList));
			}
			return;
		} else if(sumSoFar < 0) {
			return;
		}

		//action -> recursion
		for(int i=pos + 1;i<candidates.length;i++) {
			internalList.add(candidates[i]);
			backtrackingRecursionHelper(i,candidates,sumSoFar - candidates[i], target, resultList, internalList, k);
			internalList.remove(internalList.size() - 1);
		}
	}
	

	public static void main(String[] args) {
		int[] candidates = new int[] {1,2,3,4,5,6,7,8,9};
		int target = 9;
		combinationSum3(candidates, target, 3);
	}

}
