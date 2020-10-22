package algorithms.companies.gs;

/**
 * An array of costs was given. You can either take two jumps forward or one jump backward. If you land on a particular
 * index, you have to add the cost to your total. Find the minimum cost needed to cross the array or reach the end of
 * the array.
 * @author SS057631
 */
public class TwoJumpForwardOneBackwardDP {

    public static void main(String[] args) {
        int[] cost = new int[] {4,3,6,2,1,8};
        System.out.println(getMinCost(cost));
    }
    
    private static int getMinCost(int[] cost) {
        //my algo- get the min cost to reach each step
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        
        for(int i = 2; i < dp.length; i++) {
            if(i != dp.length - 1) {
                dp[i] = Math.min(dp[i-1] + cost[i+1], dp[i - 2]) + cost[i];
            } else {
                dp[i] = Math.min(dp[i-1], dp[i - 2]) + cost[i];
            }
            
        }
        return dp[cost.length - 1];
    }

}
