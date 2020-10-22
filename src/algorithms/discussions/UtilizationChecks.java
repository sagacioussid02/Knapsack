package algorithms.discussions;

import java.util.ArrayList;
import java.util.List;

public class UtilizationChecks {

	public static void main(String[] args) {
		/*
		 * List<Integer> myList = new ArrayList<Integer>(); myList.add(25);
		 * myList.add(23); myList.add(1); myList.add(2); myList.add(3); myList.add(4);
		 * myList.add(5); myList.add(6); myList.add(7); myList.add(8); myList.add(9);
		 * myList.add(10); myList.add(76); myList.add(80);
		 * System.out.println(finalInstances(2,myList)); List<Integer> myList1 = new
		 * ArrayList<Integer>(); myList1.add(5); myList1.add(10); myList1.add(80);
		 * System.out.println(finalInstances(1,myList1));
		 */
		List<Integer> myList3 = new ArrayList<Integer>();
		myList3.add(6);
		myList3.add(30);
		myList3.add(5);
		myList3.add(4);
		myList3.add(19);
		myList3.add(89);
		System.out.println(finalInstances(5,myList3));
		 
	}
	
	//Time Complexity: O(n)
	//Space COmplexity: O(1)
	public static int finalInstances(int instances, List<Integer> averageUtil) {
		
		//If there is no utilization history then return the number of instances as final number of instances
		if(averageUtil == null || averageUtil.size() == 0) {
			return instances;
		}
		
		//initialize a dynamically updating count for number of instances
		//which should be initialized to given number of instances
		int countInstances = instances;
		
		//iterate through the utilzation history list
		for(int i=0;i<averageUtil.size();i++) {
			int utilization = averageUtil.get(i);
			
			//this is to check if the utilization is less than 25
			if(utilization < 25) {
				//if utilization is less than 25 then check if instances are already 1
				//only do the auto scaling if the number of instances is more than 1
				if(countInstances != 1) {
				    countInstances = (int) Math.ceil((double)countInstances / (double)2); 
					i += 10;
				}
			} else if(utilization > 60) {
				//If utilization is greater than 60 then double the instances
				//only if it is greater than 2 * 10^8, then do nothing
				int doubleValue = (2 * countInstances);
				if(!(doubleValue > 200000000 || doubleValue < 0)) {
					countInstances = doubleValue;
					i += 10;
				}
			} 
		}
		return countInstances;
	}

}
