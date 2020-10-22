package orcl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
	
	public int[][] merge(int[][] intervals) {
		//sort according to start time
		Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
		
		//check for the maximum end time
		//then add to result list
		List<int[]> res = new ArrayList<int[]>();
		
		int max = 0;
		
		//since its sorted, first one will have the lowest start time
		//So we will add that start time to list and update end time
		//after traversing through all the intervals
		int[] current = intervals[0];
		res.add(current);
		
		for(int[] each:intervals) {
			//Overlapping: Current End time is greater than all those start times then they are overlapping in Sorted array
			//If any start time is after the current end time that means they are not overlapping
			if(each[0] <= current[1]) { //till each start time is less than already added current end time then they are overlapping
				current[1] = Math.max(current[1], each[1]);
			} else {
				current = each;
				res.add(current);
				
			}
		}
		return res.toArray(new int[res.size()][]);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
