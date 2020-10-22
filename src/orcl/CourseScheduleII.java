package orcl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * There are a total of n courses you have to take labelled from 0 to n - 1.
 * 
 * Some courses may have prerequisites, for example, if prerequisites[i] = [ai,
 * bi] this means you must take the course bi before the course ai.
 * 
 * Given the total number of courses numCourses and a list of the prerequisite
 * pairs, return the ordering of courses you should take to finish all courses.
 * 
 * If there are many valid answers, return any of them. If it is impossible to
 * finish all courses, return an empty array.
 * 
 * @author SS057631
 *
 */
public class CourseScheduleII {
	
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        
        //topological sort
        
        //Step 1. Create a graph form of representation
        Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
        for(int i=0;i<prerequisites.length;i++){
            List<Integer> adjacentListToTheNode = graph.getOrDefault(prerequisites[i][1], new ArrayList<Integer>());
            adjacentListToTheNode.add(prerequisites[i][0]);
            graph.put(prerequisites[i][1], adjacentListToTheNode);
        }
        
        //Step 2, we will do a topological sort algorithm
        //create a visited array for each node
        boolean[] visited = new boolean[numCourses];
        Stack<Integer> resultStack = new Stack<Integer>();
        for(int i=0;i<numCourses;i++){
            if(!visited[i]){
            	//if cycle is present then the method will return false
            	if(!dfs(graph, visited, i, new HashSet<Integer>(), resultStack)) {
            		return new int[] {};
            	};
            }
        }
        
        //pop the items fromm the stack and populate the array
        int[] res = new int[numCourses];
        int pos = 0;
        while(!resultStack.isEmpty()){
            res[pos++] = resultStack.pop();
        }
        return res;
    }
    
    public static boolean dfs(Map<Integer, List<Integer>> graph, boolean[] visited, int currentNode, Set<Integer> setToDetectCycle,Stack<Integer> resultStack){
    	    	
    	setToDetectCycle.add(currentNode);
        //make the current node as visited
        visited[currentNode] = true;
        
        //iterate through each nodes and add it to stack
        List<Integer> adjecentNodes = graph.get(currentNode);
        if(adjecentNodes == null) {
        	setToDetectCycle.remove(currentNode);
        	resultStack.push(currentNode);
        	return true;
        }
        
        for(Integer each:graph.get(currentNode)){
        	if(setToDetectCycle.contains(each)) {
        		return false;
        	}
            if(!visited[each]){
                if(!dfs(graph, visited, each, setToDetectCycle, resultStack)) {
                	return false;
                }
            }
        }
        //remove from set as it will not be in current dfs path
        setToDetectCycle.remove(currentNode);
        resultStack.push(currentNode);
        return true;
    }

	public static void main(String[] args) {
		
		  //int numCourses = 4; int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
		 
		
		  //int numCourses = 3; int[][] prerequisites = {{1,0},{2,1},{0,2}};
		
		int numCourses = 3; int[][] prerequisites = {{0,2},{1,2},{2,0}};
		 
		findOrder(numCourses, prerequisites);
	}

}
