package datastructures.basic.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1. Some courses may have
 * prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 * @author SS057631
 */
public class CourseSchedule1 {

    public static void main(String[] args) {
        int numCourses = 4;
        int[][] preReqs = new int[][] {{2,0},{1,0},{3,1},{3,2},{1,3}};
        System.out.println(!canFinish(numCourses,preReqs));
    }
    

    static Map<Integer, ArrayList<Integer>> graph = new HashMap<Integer, ArrayList<Integer>>();
    
    public static boolean canFinish(int numCourse, int[][] preReqs) {
        
        // Since there are prereqs involved that means one element has
        // relationships with others; could be direct or indirect which gave us the clue that
        // it is a graph problem. Once we found out the graph, it just bottles down to find cycle in the graph.
        
        //1.create graph
        //adding edges to adjacency list
        for(int i=0;i<preReqs.length;i++) {
            addDirectedEdge(graph, preReqs[i][0], preReqs[i][1]);
        }
        
        //2. detect cycle in graph using dfs
        //iterate through all the nodes one by one and perform dfs
        //need to keep track of visited node
        Set<Integer> outerVisited = new HashSet<Integer>();
        Set<Integer> innerVisited = new HashSet<Integer>();
        for(int i=0;i<numCourse;i++) {
            if(!outerVisited.contains(i) && dfs(i, outerVisited, innerVisited, graph)) return true;
        }
        return false;
    }

    //dfs recursive method
    private static boolean dfs(int i, Set<Integer> outerVisited, Set<Integer> innerVisited, Map<Integer, ArrayList<Integer>> graph) {
        innerVisited.add(i);
        outerVisited.add(i);
        List<Integer> neighbors = graph.containsKey(i)?graph.get(i):new ArrayList<Integer>();
        for(Integer neighbor:neighbors) {
            if(!innerVisited.contains(neighbor)) {
                dfs(neighbor,outerVisited,innerVisited,graph);
            } else return true;
        }
        innerVisited.remove(i);
        return false;
    }

    private static void addDirectedEdge(Map<Integer,ArrayList<Integer>> graph, int i, int j) {
        ArrayList<Integer> neighborList = graph.getOrDefault(i, new ArrayList<Integer>());
        neighborList.add(j);
        graph.put(i, neighborList);
    }

}