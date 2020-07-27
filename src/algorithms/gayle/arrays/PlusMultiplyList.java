package algorithms.gayle.arrays;

import java.util.List;

public class PlusMultiplyList {
    
    /*
     * Complete the 'plusMult' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER_ARRAY A as parameter.
     */

    public static String plusMult(List<Integer> A) {
        if(A == null || A.size() == 0) return "NEUTRAL";
        if(A.size() == 1) return "EVEN";
        if(A.size() == 2) return A.get(0) > A.get(1)?"EVEN":"ODD";
        int rEven = A.get(0);
        int rOdd = A.get(1);
        int countEven = 0;
        int countOdd = 0;
        int length = A.size();
        int index = 2;
        while(index <= length - 1){
            if(index%2 == 0){
                if(countEven%2 == 0){
                    rEven *= A.get(index);
                    countEven++;
                }else{
                    rEven += A.get(index);
                    countEven--;
                }
                
            } else{
                if(countOdd%2 == 0){
                    rOdd *= A.get(index);
                    countOdd++;
                }else{
                    rOdd += A.get(index);
                    countOdd--;
                }
                
            }
            index++;
        }
        rOdd = rOdd%2;
        rEven = rEven%2;
        if(rOdd > rEven) return "ODD";
        else if(rOdd < rEven)return "EVEN";
        else return "NEUTRAL";

    }

    public static void main(String[] args) {
        
    }

}
