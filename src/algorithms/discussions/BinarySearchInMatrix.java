package algorithms.discussions;

import java.util.function.Function;

public class BinarySearchInMatrix {

    public static void main(String[] args) {
        int[][] mat = { {10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50}};
        System.out.println(binarySearchMatrixSimpleWay(mat,29));
        System.out.println(binarySearchMatrix(mat,29));
        
    }
    
    public static boolean binarySearchMatrix(int[][] mat, int target) {
        int row = mat.length;
        int col = mat[0].length;
        int left = 0;
        int right = (row * col) - 1;
        
        while(left < right) {
            int mid = (right + left) / 2;
            left = mid / 2;
            right = mid % 2;
            
            if(mat[left][right] == target) return true;
            if(mat[left][right] < target) left = mid;
            else if(mat[left][right] > target) right = mid;
        }
        return false;
    }

    public static boolean binarySearchMatrixSimpleWay(int[][] mat, int target) {
        int left = 0;
        int right = mat[0].length - 1;
        
        while(left < mat.length && right >= 0) {
            if(mat[left][right] == target) return true;
            if(mat[left][right] < target) left++;
            else if(mat[left][right] > target) right--;
        }
        return false;
    }
    
    /*
     * public static Function<Integer, Boolean> binarySearchMatrixSimpleWay1(int[][] mat, int target) { int left = 0;
     * int right = mat[0].length - 1; while(left < mat.length && right >= 0) { if(mat[left][right] == target) return
     * true; if(mat[left][right] < target) left++; else if(mat[left][right] > target) right--; } return false; }
     */
}
