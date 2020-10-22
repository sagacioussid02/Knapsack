package algorithms.discussions;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum4 {
	
    public static List<List<Integer>> combinationSum4(int[] candidates, int target) {
		//since we need to form an array whose target sum is given we need to dynamically
		//add or remove elements from thearray which ill require backtracking
		List<List<Integer>> resultList = new ArrayList<List<Integer>>();
		List<Integer> internalList = new ArrayList<Integer>();
		backtrackingRecursionHelper(0,candidates, target, target, resultList, internalList);
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
		for(int i=pos;i<candidates.length;i++) {
			internalList.add(candidates[i]);
			backtrackingRecursionHelper(i,candidates,sumSoFar - candidates[i], target, resultList, internalList);
			internalList.remove(internalList.size() - 1);
		}
		
	}

	public static void main(String[] args) {
		int[] candidates = new int[] {1,2,3};
		int target = 4;
		combinationSum4(candidates, target);
	}

}
