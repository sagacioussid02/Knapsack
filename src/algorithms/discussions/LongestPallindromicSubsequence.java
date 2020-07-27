package algorithms.discussions;

public class LongestPallindromicSubsequence {

    public static int longestPallindromicSubsequence(String str) {
        // validations
        if (str == null)
            return 0;
        if (str.length() == 1)
            return 1;

        // initialize a 2D matrix for bottom up approach
        // (i, j) represents string starting at charAt(i) to charAt(j)
        int[][] grid = new int[str.length()][str.length()];

        // populate the diagonal representing the string of length 1 with 1
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < str.length(); j++) {
                if (i == j) {
                    grid[i][j] = 1;
                }
            }
        }

        // iterate to each cell in the upper part of diagonal in the matrix
        for (int len = 0; len < str.length(); len++) {
            for (int i= 0, j = i + len; i< str.length() && j < str.length(); i++,j++) {
                    if(i == j) grid[i][j] = 1;
                    // if charAt(i) and charAt(j) are equal
                    else if (str.charAt(i) == str.charAt(j)) {
                        // then get the diagonal and add 2 -> (i-1,j-1)+2
                        grid[i][j] = grid[i + 1][j - 1] + 2;
                    } else {
                        // else get max of (i-1,j),(i,j-1) and (i-1,j-1)
                        grid[i][j] = Math.max(grid[i][j - 1], grid[i + 1][j]);
                    }
            }
        }
        return grid[0][str.length() - 1];

    }

    public static int longestPallindromicSubsequenceRecursive(String str) {
        return recursionHelper(str, 0, str.length() - 1);
    }

    public static int recursionHelper(String str, int startIndex, int endIndex) {
        if (str == null)
            return 0;
        if (str.length() == 1)
            return 1;
        if (startIndex == endIndex)
            return 1;
        if (str.charAt(startIndex) == str.charAt(endIndex))
            return recursionHelper(str, startIndex + 1, endIndex - 1) + 2;
        else
            return Math.max(recursionHelper(str, startIndex + 1, endIndex), recursionHelper(str, startIndex, endIndex
                    - 1));
    }

    public static void main(String[] args) {
        System.out.println(longestPallindromicSubsequence("facbca"));
        System.out.println(longestPallindromicSubsequenceRecursive("facbca"));
    }

}
