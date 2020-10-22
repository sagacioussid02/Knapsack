package algorithms.discussions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

public class ShoppingPatterns {
	
	public static int getMinScore(int productNodes, List<Integer> productsFrom, List<Integer> productsTo) {
		//create the graph
		Map<Integer, List<Integer>> graph = createGraph(productNodes, productsFrom, productsTo);
		//idea is find out the trio
		Set<List<Integer>> trios = getTrios(graph);
		//get the common ones and calculate the min score
		int min = Integer.MAX_VALUE;
		for(List<Integer> trio : trios) {
			int node1 = trio.get(0);
			int node2 = trio.get(1);
			int node3 = trio.get(2);
			int val1 = getValueForNode(node1, node2, node3, graph);
			int val2 = getValueForNode(node2, node1, node3, graph);
			int val3 = getValueForNode(node3, node2, node1, graph);
			min = Math.min(min, (val1 + val2 + val3));
		}
		return min;
		
	}
	
	public static int getValueForNode(int node,int node1, int node2, Map<Integer, List<Integer>> graph) {
		int val = 0;
		if(graph.get(node).contains(node1) && graph.get(node).contains(node2)) {
			val = graph.get(node).size() - 2;
		} else if(graph.get(node).contains(node1) || graph.get(node).contains(node2)) {
			val = graph.get(node).size() - 1;
		} else {
			val = graph.get(node).size();
		}
		return val;
	}
	
	//check the neighbors of each node and verify if any two neighbors are each other's neighbors
	private static Set<List<Integer>> getTrios(Map<Integer, List<Integer>> graph){
		Set<List<Integer>> trios = new HashSet<List<Integer>>();
		for(Integer eachNode:graph.keySet()) {
			List<Integer> neighbors = graph.get(eachNode);
			
			for(Integer eachNeighbor:neighbors) {
				//check if there is any other neighbor in current node's neighbor list
				//is also a neighbor of eachNeighbor
				List<Integer> neighborsOfEachNeighbor = graph.get(eachNeighbor);
				//In short we need to find a third node which is in both the list
				List<Integer> trio = new ArrayList<Integer>();
				for(Integer neighborOfEachNeighbor : neighborsOfEachNeighbor) {
					if(neighbors.contains(neighborOfEachNeighbor)) {
						trio.add(eachNode);
						trio.add(eachNeighbor);
						trio.add(neighborOfEachNeighbor);
					}
				}
				
				//when trios is empty
				//this will run only once
				if(trios.isEmpty() && !trio.isEmpty()) {
					trios.add(new ArrayList<Integer>(trio));
				} else {
					for(List<Integer> eachTrio:trios) {
						if(!trio.isEmpty() && !eachTrio.containsAll(trio)) {
							trios.add(new ArrayList<Integer>(trio));
						}
					}
				}
			}
		}
		return trios;
	}
	
	private static void getAllPathsInAGraph(Map<Integer, List<Integer>> graph) {
		//idea is to dfs through the nodes and record the cycle if its length is 3
		//for dfs you will need a visited list, a list to store the nodes in each iteration, a main list of list
		Set<List<Integer>> resultList = new HashSet<List<Integer>>();
		for(Integer node:graph.keySet()) {
			List<Integer> visited = new ArrayList<Integer>();
			List<Integer> currentList = new ArrayList<Integer>();
			List<Integer> parentNodesList = new ArrayList<Integer>();
			//add current node first since in dfs we will only be looking at neighbors
			currentList.add(node);
			parentNodesList.add(node);
			dfs(visited, currentList, resultList, graph, node, node, parentNodesList);
		}
	}
	
	private static void dfs(List<Integer> visited, List<Integer> currentList, Set<List<Integer>> resultList,
			Map<Integer, List<Integer>> graph, Integer currentNode, Integer sourceNode, List<Integer> parentNodes) {
		visited.add(currentNode);
		
		//see all its neighbors and go to depth using recursive stack one by one
		for(Integer eachNeighbor : graph.get(currentNode)) {
			if(!visited.contains(eachNeighbor)) {
				currentList.add(eachNeighbor);
				dfs(visited, currentList, resultList, graph, eachNeighbor, sourceNode, parentNodes);
			} 
		}
		
		if(!parentNodes.contains(currentNode)) {
			resultList.add(new ArrayList<Integer>(currentList));
			for(Integer each:currentList) {
				parentNodes.add(each);
			}
		}
		currentList.remove(currentNode);
	}

	private static Map<Integer, List<Integer>> createGraph(int productNodes, List<Integer> productsFrom, List<Integer> productsTo){
		Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
		for(int i=0;i<productNodes;i++) {
			List<Integer> neighbors1 = graph.getOrDefault(productsFrom.get(i), new ArrayList<Integer>());
			neighbors1.add(productsTo.get(i));
		    graph.put(productsFrom.get(i), neighbors1);
			List<Integer> neighbors2 = graph.getOrDefault(productsTo.get(i), new ArrayList<Integer>());
			neighbors2.add(productsFrom.get(i));
		    graph.put(productsTo.get(i), neighbors2);
		}
		return graph;
	}
	
	public static void main(String[] args) {
		List<Integer> productsFrom = new ArrayList<Integer>();
		productsFrom.add(1);
		productsFrom.add(2);
		productsFrom.add(2);
		productsFrom.add(3);
		productsFrom.add(4);
		productsFrom.add(5);
		List<Integer> productsTo = new ArrayList<Integer>();
		productsTo.add(2);
		productsTo.add(4);
		productsTo.add(5);
		productsTo.add(5);
		productsTo.add(5);
		productsTo.add(6);
		getMinScore(6, productsFrom, productsTo);
		
	}

}
