package algorithms.discussions;

import java.util.Random;

public class GenerateRandomNumbers {
    
    private static final int MAX = 5;

    private static Random rand = new Random();
    private static int maxRand = 0;

    public static int getIncreasingRandomNumber() {
        maxRand += rand.nextInt(MAX);
        return maxRand;
    }
    
    public static void main(String[] args) {
        for(int i=0;i<5;i++) {
            System.out.println(getIncreasingRandomNumber());
        }
        
    }

}
