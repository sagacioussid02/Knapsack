package algorithms.companies.cisco;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProfitTargets {
	
	public static int getPairsOfProfitTargets(List<Integer> arr, long target){
		Set<List<Integer>> res = new HashSet<List<Integer>>();
		Map<Integer, Integer> arrMap = new HashMap<Integer, Integer>();
		for(int i = 0; i< arr.size();i++) {
			int curr = arr.get(i);
			if(arrMap.containsKey(curr)) {
				List<Integer> localList = new ArrayList<Integer>();
				localList.add(curr);
				localList.add((int)target - curr);
				res.add(localList);
			} else {
				arrMap.put((int)target - curr, i);
			}
		}
		return res.size();
	}

	public static void main(String[] args) {
		/*
		 * int[] arr = new int[] {5, 7, 9, 13, 11, 6, 6, 3, 3};
		 * getPairsOfProfitTargets(arr, 12);
		 */
		
		//int[] arr1 = new int[] {6, 1, 3, 46, 1, 3, 9, 47};
		List<Integer> chocs = new ArrayList<Integer>();
		chocs.add(6);
		chocs.add(1);
		chocs.add(3);
		chocs.add(46);
		chocs.add(1);
		chocs.add(3);
		chocs.add(9);
		chocs.add(47);
		getPairsOfProfitTargets(chocs, new Long(47));
		
	}

}
