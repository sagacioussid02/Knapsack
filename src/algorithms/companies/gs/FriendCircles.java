package algorithms.companies.gs;

/**
 * LC:547 There are N students in a class. Some of them are friends, while some are not. Their friendship is transitive in
 * nature. For example, if A is a direct friend of B, and B is a direct friend of C, then A is an indirect friend of C.
 * And we defined a friend circle is a group of students who are direct or indirect friends. Given a N*N matrix M
 * representing the friend relationship between students in the class. If M[i][j] = 1, then the ith and jth students are
 * direct friends with each other, otherwise not. And you have to output the total number of friend circles among all
 * the students.
 * @author SS057631
 */
public class FriendCircles {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    
    public static int findCircleNum(int[][] M) {
        int[] visit = new int[M.length];
        int count = 0;
        for(int i=0;i<M.length;i++) {
            if(visit[i] == 0) {
                dfs(M, visit, i);
                count++;
            }
        }
        return count;
    }

    private static void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }

}
