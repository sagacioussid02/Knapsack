package orcl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ThreeSum {
	
    public static List<List<Integer>> threeSum(int[] nums) {
        if(nums == null || nums.length < 3) return Collections.emptyList();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        //to check for duplicate values
        Set<Integer> dups = new HashSet<Integer>();
        
        for(int i=0;i<nums.length;i++){
            if(dups.add(nums[i])){
                twoSum(nums,res,i,dups);
            }
        }
        return res;
    }
    
    public static void twoSum(int[] nums, List<List<Integer>> res, int pos, Set<Integer> dups){
        Map<Integer,Integer> myMap = new HashMap<Integer,Integer>();
        //twoSum
        for(int i=pos+1;i<nums.length;i++){
            int compliment = -nums[i] - nums[pos];
            if(myMap.containsKey(nums[i])){
                List<Integer> triplet = Arrays.asList(nums[i], nums[pos], compliment);
                Collections.sort(triplet);
                res.add(triplet);
                dups.add(nums[i]);
            }
            myMap.put(compliment,i);
        }
    }

	public static void main(String[] args) {
		int[] nums = {-1,0,1,2,-1,-4};
		threeSum(nums);
	}

}
