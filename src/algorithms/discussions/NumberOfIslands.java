package algorithms.discussions;

/**
 * Number of Islands
 * @author SS057631
 *
 */
public class NumberOfIslands {

	public static void main(String[] args) {
		int[] dx = {-1,0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		int[][] mat = new int[][] {{1,1,1,1},{1,0,0,1},{0,0,1,1},{0,1,0,1}}; 
		int count = 0;
		boolean[][] visited = new boolean[mat.length][mat[0].length];
		
		for(int i=0;i<mat.length;i++) {
			for(int j=0;j<mat[0].length;j++) {
				if(mat[i][j]==1&&!visited[i][j]) {
				  dfs(visited, i, j, mat, dx, dy);
				  count++;
				}
			}
		}
		System.out.println(count);
	}
	
	public static void dfs(boolean[][] visited, int i, int j, int[][] mat, int[] dx, int[] dy) {
		visited[i][j] = true;
		
		for(int p=0;p<4;p++) {
			int x = i + dx[p];
			int y = j + dy[p];
			if(x >= 0 && x<mat.length && y>=0 && y<mat[0].length && !visited[x][y]&&mat[x][y]==1) {
				dfs(visited, x, y, mat, dx, dy);
			}
		}
		
	}

}
