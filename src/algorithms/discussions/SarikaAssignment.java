package algorithms.discussions;

import java.util.HashMap;
import java.util.Map;

public class SarikaAssignment {
	
	// Number of vertices in the graph
    private static final int totalVertex = 8;

	public static void main(String[] args) {
		char[][] grid = createGrid();
		//getMap of node and position
		Map<Character, Integer[]> mapOfNodeByPos = getMapOfNodeAndPosition(grid);
		//create graph
		double[][] graph = createGraph(grid,mapOfNodeByPos,totalVertex);
		
		//find minimum spanning tree using Prim's algorithm
		int[][] mst = primMST(graph);
		
		//perform dfs over it
		int totalHamiltonianCost = 0;
		int[][] visited = new int[mst.length][mst[0].length];
		for(int i=0;i<mst.length;i++) {
			for(int j=0;j<mst[0].length;j++) {
				if(mst[i][j] != 0 && visited[i][j] == 0) {
					totalHamiltonianCost += dfs(mst, mst[i][j], visited, i, j);
				}
			}
		}
		System.out.println("Total hamiltonian cost = "+totalHamiltonianCost);
	}
	

 
    private static int dfs(int[][] mst, int currentNode, int[][] visited, int row, int col) {
    	visited[row][col] = 1;
    	
    	for(int i=0;i<mst[0].length;i++) {
    		if(visited[row][i] != 1 && mst[row][i] != 0) {
    			dfs(mst,mst[row][i],visited,row,i);
    		}
    	}
		return mst[row][col];
    	
	}



	// A utility function to find the vertex with minimum key
    // value, from the set of vertices not yet included in MST
    static int minKey(int key[], Boolean mstSet[])
    {
        // Initialize min value
        int min = Integer.MAX_VALUE, min_index = -1;
 
        for (int v = 0; v < totalVertex; v++)
            if (mstSet[v] == false && key[v] < min) {
                min = key[v];
                min_index = v;
            }
 
        return min_index;
    }
 
    // A utility function to print the constructed MST stored in
    // parent[]
    static int[][] printMST(int parent[], double graph[][])
    {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < totalVertex; i++)
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
        
        //create a graph representation to perform dfs
        //use adjacency matrix to create a minimum spanning tree representation
        int[][] mst = new int[totalVertex][totalVertex];
        for (int i = 1; i < totalVertex; i++) {
        	mst[parent[i]][i] = (int) graph[i][parent[i]];
        }
        System.out.println();
        return mst;
    }
 
    // Function to construct and print MST for a graph represented
    // using adjacency matrix representation
    static int[][] primMST(double graph[][])
    {
        // Array to store constructed MST
        int parent[] = new int[totalVertex];
 
        // Key values used to pick minimum weight edge in cut
        int key[] = new int[totalVertex];
 
        // To represent set of vertices included in MST
        Boolean mstSet[] = new Boolean[totalVertex];
 
        // Initialize all keys as INFINITE
        for (int i = 0; i < totalVertex; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }
 
        // Always include first 1st vertex in MST.
        key[0] = 0; // Make key 0 so that this vertex is
        // picked as first vertex
        parent[0] = -1; // First node is always root of MST
 
        // The MST will have V vertices
        for (int count = 0; count < totalVertex - 1; count++) {
            // Pick the minimum key vertex from the set of vertices
            // not yet included in MST
            int u = minKey(key, mstSet);
 
            // Add the picked vertex to the MST Set
            mstSet[u] = true;
 
            // Update key value and parent index of the adjacent
            // vertices of the picked vertex. Consider only those
            // vertices which are not yet included in MST
            for (int v = 0; v < totalVertex; v++)
 
                // graph[u][v] is non zero only for adjacent vertices of m
                // mstSet[v] is false for vertices not yet included in MST
                // Update the key only if graph[u][v] is smaller than key[v]
                if (graph[u][v] != 0 && mstSet[v] == false && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = (int) graph[u][v];
                }
        }
 
        // print the constructed MST
        return printMST(parent, graph);
    }
 

	private static Map<Character, Integer[]> getMapOfNodeAndPosition(char[][] grid) {
		Map<Character, Integer[]> myMap = new HashMap<Character, Integer[]>();
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[0].length;j++) {
				if(grid[i][j] == '\u0000') {
					continue;
				} else {
					myMap.put(grid[i][j], new Integer[] {i,j});
				}
			}
		}
		return myMap;
	}

	private static double[][] createGraph(char[][] grid, Map<Character, Integer[]> mapOfNodeByPos, int totalVertex) {
		double[][] graph = new double[totalVertex][totalVertex];
		
		for(int i=0;i<graph.length;i++) {
			char u = (char)(i + 'A');
			for(int j=0;j<graph[0].length;j++) {
				char v = (char)(j + 'A');
				if(i==j) {
					graph[i][j] = 0.0;
				} else {
					int vertex1x = mapOfNodeByPos.get(u)[0];
					int vertex1y = mapOfNodeByPos.get(u)[1];
					int vertex2x = mapOfNodeByPos.get(v)[0];
					int vertex2y = mapOfNodeByPos.get(v)[1];
					graph[i][j] = getHamiltonianDistance(vertex1x, vertex1y, vertex2x, vertex2y);
				}
				
			}
		}
		return graph;
	}

	private static double getHamiltonianDistance(int vertex1x, int vertex1y, int vertex2x, int vertex2y) {
		int x2 = (int) Math.pow(Math.abs(vertex1x - vertex2x), 2);
		int y2 = (int) Math.pow(Math.abs(vertex1y - vertex2y), 2);
		return Math.pow(x2+y2, 0.5);
	}

	private static char[][] createGrid() {
		char[][] grid = new char[7][8];
		grid[1][2] = 'A';
		grid[1][4] = 'D';
		grid[2][5] = 'E';
		grid[3][2] = 'B';
		grid[3][4] = 'F';
		grid[3][6] = 'G';
		grid[4][1] = 'C';
		grid[5][3] = 'H';
		return grid;
	}

}
