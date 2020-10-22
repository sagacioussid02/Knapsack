package algorithms.companies.gs;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * We have n jobs, where every job is scheduled to be done from startTime[i] to endTime[i], obtaining a profit of
 * profit[i]. You're given the startTime , endTime and profit arrays, you need to output the maximum profit you can take
 * such that there are no 2 jobs in the subset with overlapping time range. If you choose a job that ends at time X you
 * will be able to start another job that starts at time X.
 **/
public class MaxProfitJobScheduling1235 {

    public static void main(String[] args) {
                        
        /*
         * int[] startTime = new int[] {1,2,3,3}; int[] endTime = new int[] {3,4,5,6}; int[] profit = new int[]
         * {50,10,40,70};
         */
           
        
        /*
         * int[] startTime = new int[] {1,2,3,4,6}; int[] endTime = new int[] {3,5,10,6,9}; int[] profit = new int[]
         * {20,20,100,70,60};
         */
        
        
        /*
         * int[] startTime = new int[] {6,15,7,11,1,3,16,2}; int[] endTime = new int[] {19,18,19,16,10,8,19,8}; int[]
         * profit = new int[] {2,9,1,19,5,7,3,19};
         */
         
        
        
          int[] startTime = new int[] {1,1,1}; int[] endTime = new int[] {2,3,4}; int[] profit = new int[] {5,6,4};
        
        //if the start time is repeating then we should combine all the 3 parameters
        int[][] combinedData = new int[startTime.length][3];
        for(int i=0;i<startTime.length;i++) {
            combinedData[i][0] = startTime[i];
            combinedData[i][1] = endTime[i];
            combinedData[i][2] = profit[i];
        }
        Arrays.sort(combinedData, (a1,a2) -> a1[0] - a2[0]);
        
        //System.out.println(maxProfitJobScheduling(startTime, sortedEndTime, sortedProfit));
        System.out.println(maxProfitJobSchedulingRepeatingStartTimes(combinedData));
    }
    
    //assuming start time is sorted
    private static int maxProfitJobScheduling(int[] startTime, int[] endTime, int[] profit) {
        //find the max effectiveness including and excluding an add
        int length = startTime.length;
        int[] include = new int[length];
        int[] exclude = new int[length];
        include[length - 1] = profit[length -1];
        exclude[length - 1] = 0;
        for(int i = length - 2;i >= 0; i--) {
            int endingTime = endTime[i];
            int j = i + 1;
            while(j < length && startTime[j] < endingTime) {
                j++;
            }
            include[i] = Math.max((j > length - 1)?0:include[j], (j > length - 1)?0:exclude[j]) +  profit[i];
            exclude[i] = Math.max(include[i+1], exclude[i+1]);
        }
        return Math.max(include[0], exclude[0]);
    }
    
    private static int maxProfitJobSchedulingRepeatingStartTimes(int[][] combinedData) {
        //find the max effectiveness including and excluding an add
        int length = combinedData.length;
        int[] include = new int[length];
        int[] exclude = new int[length];
        include[length - 1] = combinedData[length -1][2];
        exclude[length - 1] = 0;
        for(int i = length - 2;i >= 0; i--) {
            int endingTime = combinedData[i][1];
            int j = i + 1;
            while(j < length && combinedData[j][0] < endingTime) {
                j++;
            }
            include[i] = Math.max((j > length - 1)?0:include[j], (j > length - 1)?0:exclude[j]) +  combinedData[i][2];
            exclude[i] = Math.max(include[i+1], exclude[i+1]);
        }
        return Math.max(include[0], exclude[0]);
    }

}
