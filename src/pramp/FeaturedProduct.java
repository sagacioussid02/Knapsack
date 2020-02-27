package pramp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class FeaturedProduct {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("yellowShirt");
		list.add("redHat");
		list.add("blackShirt");
		list.add("bluePants");
		list.add("redHat");
		list.add("pinkHat");
		list.add("blackShirt");
		list.add("yellowShirt");
		list.add("greenPants");
		list.add("greenPants");
		System.out.println(featuredProduct(list));
	}
	
	 public static String featuredProduct(List<String> products) {
		    // Write your code here
		    //Use a treeMap to sort the inputs by value
		    // Add it to priority Queue and remove the first Entry element
		    //keep removing from Priority Queue till you get unequal value

		    Map<String, Integer> productByCount = new HashMap<String, Integer>();
		    for(String each: products){
		        productByCount.put(each, productByCount.getOrDefault(each, 0) + 1);
		    }

		    PriorityQueue<Map.Entry<String, Integer>> qu = new PriorityQueue<>((e1,e2)->{
		    	int compare = e2.getValue() - e1.getValue();
		    	return compare == 0? (products.indexOf(e1.getKey()) > products.indexOf(e2.getKey()))?1:-1:e2.getValue() - e1.getValue();
		    });
		    
		    for(Map.Entry<String,Integer> entry: productByCount.entrySet()) {
		    	qu.add(entry);
		    }
		    
		    return qu.remove().getKey();
		    }


}
