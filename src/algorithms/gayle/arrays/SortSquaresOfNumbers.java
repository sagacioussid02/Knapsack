package algorithms.gayle.arrays;

import java.util.ArrayList;
import java.util.List;

public class SortSquaresOfNumbers {
    
    public static List<Integer> sortSquare(int[] arr) {
        List<Integer> lst = new ArrayList<Integer>();
        int[] res = new int[getSquare(arr.length)];
        
        for(int each:arr) {
            int a = getSquare(each);
            res[a] +=1;
        }
        
        //iterate through the res and check if the value is greater than 0
        for(int i = 0; i < res.length; i++) {
            if(res[i] > 0) {
                int iter = res[i];
                while(iter > 0) {
                    lst.add(i);
                    iter--;
                }
            }
        }
        return lst;
    }
    
    public static int getSquare(int n) {
        return (n * n);
    }

    public static void main(String[] args) {
        sortSquare(new int[] {-2, 1, 2}).stream().forEach(System.out::println);
    }

}
