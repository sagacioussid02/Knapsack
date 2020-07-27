package algorithms.discussions;

public class SecondSmallestNumberInArray {

    public static void main(String[] args) {
        System.out.println(getSecondSmallestNumber(new int[] {5,4,2,6,9,1,1,3}));
    }
    
    private static int getSecondSmallestNumber(int[] arr) {
        if(arr.length < 2) return 0;
        
        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        for(int i=0; i<arr.length;i++) {
            int curr = arr[i];
            /* If current element is smaller than first 
            then update both first and second */
            if(curr < firstMin) {
                secondMin = firstMin;
                firstMin = curr;
            } else if(curr < secondMin && curr != firstMin) {
                secondMin = curr;
            }
        }
        return secondMin;
    }

}
