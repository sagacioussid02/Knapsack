package algorithms.discussions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

/**
 * Given a collection of candidate numbers (candidates) and a target number
 * (target), find all unique combinations in candidates where the candidate
 * numbers sums to target.
 * 
 * Each number in candidates may only be used once in the combination.
 * 
 * Input: candidates = [10,1,2,7,6,1,5], target = 8, A solution set is: [ [1,
 * 7], [1, 2, 5], [2, 6], [1, 1, 6] ]
 * 
 * @author SS057631
 *
 */
public class CombinationSum2 {
	
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		//since we need to form an array whose target sum is given we need to dynamically
		//add or remove elements from the array which ill require backtracking
		
		Set<List<Integer>> resultList = new HashSet<List<Integer>>();
		List<Integer> internalList = new ArrayList<Integer>();
		Arrays.sort(candidates);
		backtrackingRecursionHelper(-1,candidates, target, target, resultList, internalList);
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		results.addAll(resultList);
		return results;
	}

	private static void backtrackingRecursionHelper(int pos, int[] candidates, int sumSoFar, int target,
			Set<List<Integer>> resultList, List<Integer> internalList) {
		//stopping condition
		if(pos > candidates.length - 1 || sumSoFar < 0) return;
		if(sumSoFar == 0) {
			resultList.add(new ArrayList<Integer>(internalList));
			return;
		} else if(sumSoFar < 0) {
			return;
		}

		//action -> recursion
		for(int i=pos + 1;i<candidates.length;i++) {
			internalList.add(candidates[i]);
			backtrackingRecursionHelper(i,candidates,sumSoFar - candidates[i], target, resultList, internalList);
			internalList.remove(internalList.size() - 1);
		}
	}

	public static void main(String[] args) {
		int[] candidates = new int[] {10,1,2,7,6,1,5};
		int target = 8;
		combinationSum(candidates, target);
	}

}
