package orcl;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKLists {
	
	public static List<Integer> mergeKArrayList(List<List<Integer>> lists){
		PriorityQueue<List<Integer>> qu = new PriorityQueue<List<Integer>>((l1, l2) -> {
			return l1.get(0) - l2.get(0);
		});
		for(List<Integer> each:lists) {
			qu.add(each);
		}
		
		
		while(!qu.isEmpty() && qu.size() > 1) {
			List<Integer> polledList1 = qu.poll();
			List<Integer> polledList2 = qu.poll();
			List<Integer> tempList = new ArrayList<Integer>();
			//merge two lists at first
			int pos = 0;
			int l1 = 0;
			int l2 = 0;
			while(l1 < polledList1.size() && l2 < polledList2.size()) {
				int toAdd = polledList1.get(l1) >= polledList2.get(l2) ? polledList2.get(l2++) : polledList1.get(l1++);
				tempList.add(pos++,toAdd);
			}
			
			//add the rest of the elements
			if(l1 == polledList1.size() && l2 < polledList2.size()) {
				while(l2 < polledList2.size()) {
					tempList.add(pos++,polledList2.get(l2++));
				}
			} else {
				while(l1 < polledList1.size()) {
					tempList.add(pos++,polledList1.get(l1++));
				}
			}
			
			//push it back to PQ
			qu.add(tempList);
		}
		return qu.poll();
	}

	public static void main(String[] args) {
		List<Integer> l1 = new ArrayList<Integer>();
		List<Integer> l2 = new ArrayList<Integer>();
		List<Integer> l3 = new ArrayList<Integer>();
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		
		l1.add(2);
		l1.add(4);
		l1.add(6);
		l1.add(8);
		
		l2.add(1);
		l2.add(3);
		l2.add(5);
		
		l3.add(0);
		l3.add(8);
		l3.add(9);
		
		lists.add(l1);
		lists.add(l3);
		lists.add(l2);
		
		mergeKArrayList(lists);
	}

}
