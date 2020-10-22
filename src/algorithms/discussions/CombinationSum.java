package algorithms.discussions;

import java.util.ArrayList;
import java.util.List;


/**
 * Given an array of distinct integers candidates and a target integer target,
 * return a list of all unique combinations of candidates where the chosen
 * numbers sum to target. You may return the combinations in any order.
 * 
 * The same number may be chosen from candidates an unlimited number of times.
 * Two combinations are unique if the frequency of at least one of the chosen
 * numbers is different.
 * 
 * It is guaranteed that the number of unique combinations that sum up to target
 * is less than 150 combinations for the given input.
 * 
 * Ex -> candidates = [2,3,6,7], target = 7, o/p -> Output: [[2,2,3],[7]]
 * 
 * @author SS057631
 *
 */
public class CombinationSum {
	
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		//since we need to form an array whose target sum is given we need to dynamically
		//add or remove elements from thearray which ill require backtracking
		
		List<List<Integer>> resultList = new ArrayList<List<Integer>>();
		List<Integer> internalList = new ArrayList<Integer>();
		//internalList.add(candidates[0]);
		backtrackingRecursionHelper(-1,candidates, target, target, resultList, internalList);
		return resultList;
	}

	private static void backtrackingRecursionHelper(int pos, int[] candidates, int sumSoFar, int target,
			List<List<Integer>> resultList, List<Integer> internalList) {
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
		int[] candidates = new int[] {7,3,6,2};
		int target = 7;
		combinationSum(candidates, target);
	}

}
