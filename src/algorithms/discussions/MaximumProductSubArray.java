package algorithms.discussions;

/**
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has
 * the largest product. Ex:- [2,3,-2,4] -> 6
 * @author SS057631
 */
public class MaximumProductSubArray {

    public static int maxProductSubArray(int[] arr) {
        // validations
        if(arr.length == 0) return 0;
        if(arr.length == 1) return arr[0];

        int length = arr.length;
        // initialize a variable to store max, initialize array to store max so far, initialize an array to track
        // negative products
        int[] res = new int[length];
        int max = Math.max(0, arr[length - 1]);
        res[length - 1] = arr[length - 1];
        int[] negativeTracker = new int[arr.length];
        negativeTracker[length - 1] = arr[length - 1] >= 0 ? 0 : arr[length - 1]; 
        
        //iterate from the right of the array
        for(int i = length - 2; i >= 0; i--) {
            max=Math.max(arr[i],arr[i]*res[i+1]); 
            if(negativeTracker[i+1]!=0) max = Math.max(max,arr[i]*negativeTracker[i+1]);                    
            negativeTracker[i]=0;
            if(arr[i]<0) negativeTracker[i]=arr[i];
            if(arr[i]*res[i+1]<0) negativeTracker[i]=Math.min(negativeTracker[i],arr[i]*res[i+1]);
            if(arr[i]*negativeTracker[i+1]<0)negativeTracker[i]=Math.min(negativeTracker[i],arr[i]*negativeTracker[i+1]);
        }
        return max;
    }
    

    public static void main(String[] args) {
        System.out.println(maxProductSubArray(new int[] {1,2,3,4}));
        System.out.println(maxProductSubArray(new int[] {1,2,-3,4}));
        System.out.println(maxProductSubArray(new int[] {-3,2,-3,4}));
        System.out.println(maxProductSubArray(new int[] {-3,2,0,4}));
        System.out.println(maxProductSubArray(new int[] {-4,-3,-2}));
    }

}
