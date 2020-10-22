package algorithms.discussions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Every time you open the a product page on Amazon you can see a section
 * “People who viewed this also viewed”. Now given a product relationship
 * represented as a graph(adjacent list), find out the largest connected
 * component on this graph...
 * 
 * @author SS057631
 *
 */

public class FindLongestProductsRelationship {
	
	public static List<String> findRelatedProducts(List<List<String>> graph){
		//create graph
		Map<String, Set<String>> processedGraph = new HashMap<String, Set<String>>();
		for(List<String> each:graph) {
			for(int i=0;i<each.size() - 1;i++) {
				int j=i+1;
				Set<String> prodList1 = processedGraph.getOrDefault(each.get(i), new HashSet<String>());
				prodList1.add(each.get(j));
				processedGraph.put(each.get(i), prodList1);
				Set<String> prodList2 = processedGraph.getOrDefault(each.get(j), new HashSet<String>());
				prodList2.add(each.get(i));
				processedGraph.put(each.get(j), prodList2);
			}
		}
		
		//dfs to get the longest list
		List<List<String>> result = new ArrayList<List<String>>();
		processedGraph.forEach((product,listOfProducts) -> {
			Set<String> visited = new HashSet<String>();
			List<String> localList = new ArrayList<String>();
			localList.add(product);
			dfs(product, product, listOfProducts, processedGraph, visited, result,localList);
		});
		
		//get the maximum length from the lists in results
		int max = 0;
		List<String> longestResult = new ArrayList<String>();
		for(List<String> resultList:result) {
			if(resultList.size() > max) {
				longestResult = resultList;
			}
		}
		
		return longestResult;
		
	}

	private static void dfs(String startingNode, String eachProuct, Set<String> listOfProducts, Map<String, Set<String>> processedGraph, 
			Set<String> visited, List<List<String>> result, List<String> localList) {
		visited.add(eachProuct);
		
		Set<String> neighbors = processedGraph.get(eachProuct);
		for(String eachNeighbor:neighbors) {
			if(!visited.contains(eachNeighbor)) {
				localList.add(eachNeighbor);
				dfs(startingNode, eachNeighbor, listOfProducts, processedGraph, visited, result, localList);
			}
		}
		
		if(eachProuct.equals(startingNode)) {
			result.add(localList);
		}
	}

	public static void main(String[] args) {
		//create adjacency list
		String prod1 = "product1";
		String prod2 = "product2";
		String prod3 = "product3";
		String prod4 = "product4";
		String prod5 = "product5";
		String prod6 = "product6";
		String prod7 = "product7";
		String prod8 = "product8";
		List<List<String>> graph = new ArrayList<List<String>>();
		List<String> connectedProds = new ArrayList<String>();
		connectedProds.add(prod1);
		connectedProds.add(prod2);
		connectedProds.add(prod3);
		graph.add(connectedProds);
		connectedProds = new ArrayList<String>();
		connectedProds.add(prod5);
		connectedProds.add(prod2);
		graph.add(connectedProds);
		connectedProds = new ArrayList<String>();
		connectedProds.add(prod8);
		connectedProds.add(prod7);
		graph.add(connectedProds);
		connectedProds = new ArrayList<String>();
		connectedProds.add(prod6);
		connectedProds.add(prod7);
		graph.add(connectedProds);
		connectedProds = new ArrayList<String>();
		findRelatedProducts(graph).stream().forEach(System.out::println);;
	}
	


}
