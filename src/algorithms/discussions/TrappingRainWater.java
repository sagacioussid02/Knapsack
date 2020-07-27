package algorithms.discussions;

public class TrappingRainWater {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    
    private static int trappingRainWater(int[] arr) {
        int vol = 0;
        
        //find the max to the left of a building
        int[] maxToLeft = new int[arr.length];
        maxToLeft[0] = 0;
        for(int i=0;i<arr.length;i++) {
            maxToLeft[i] = Math.max(maxToLeft[i-1], arr[i]);
        }
        
        int[] maxToRight = new int[arr.length];
        maxToRight[arr.length - 1] = 0;
        for(int i=arr.length - 2;i>=0;i--) {
            maxToRight[i] = Math.max(maxToRight[i+1], arr[i]);
        }
        
        //calculate volume trapped by each building
        for(int i = 0; i < arr.length; i++) {
            vol += Math.min(maxToLeft[i], maxToRight[i]) - arr[i];
        }
        
        return vol;
    }

}
