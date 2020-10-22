package orcl;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LeastNumberOfUniqueIntAfterKRemovals {
	
    public static int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> numByCount = new HashMap<Integer, Integer>();
        for(int each:arr){
            numByCount.put(each, numByCount.getOrDefault(each, 0) + 1);
        }
        
        PriorityQueue<Map.Entry<Integer, Integer>> qu = new PriorityQueue<Map.Entry<Integer, Integer>>(
        (e1, e2) -> {
            return e1.getValue() - e2.getValue();
        });
        
        //add elements of map to the heap
        for(Map.Entry<Integer,Integer> eachEntry:numByCount.entrySet()){
            qu.add(eachEntry);
        }
        
        while(k > 0 && !qu.isEmpty()){
            Map.Entry<Integer, Integer> elementToRemove = qu.poll();
            if(elementToRemove.getValue() > 1) {
                elementToRemove.setValue(elementToRemove.getValue() - 1);
                qu.add(elementToRemove);
            }
            k--;
            
        }
        
        return qu.size();
    }

	public static void main(String[] args) {
		int[] nums = {5,5,4};
		findLeastNumOfUniqueInts(nums, 1);
	}

}
