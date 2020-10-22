package algorithms.companies.gs;

/**
 * Q2You are the owner of a news channel and you have a show which starts at 0 and ends at M. You have N number of
 * advertisements and each ad has an effectiveness value associated with it which is given in an array of size ‘n’ in
 * the format [v1, v2, …, vn]. The time when the ads can be shown is given in the format [(x1, y1), (x2, y2), …, (xn,
 * yn)], where ith tuple in the array denotes the timing of the ith ad in the format (startTime, endTime). You have to
 * maximize the sum of the effectiveness values of the ads if the minimum time gap between two advertisements is 4 min.
 * So, if you select to show an ad having timings as (1,5), then you cannot show the next ad before 10. So next ad
 * (9,14) cannot be possible, but ad (10,14) can be. Constraints: m>=xi,yi>=0 For example, m = 20, Ads: [(6, 9), (9,
 * 11), (11, 14), (14, 18)] Effectiveness values are [9, 10, 6, 7], Ans: ad 0 and ad 4 (zero-based-indexing) Max.
 * effectiveness = 16
 * @author SS057631
 */

public class AdvertisementsAndEffectiveness {

    public static void main(String[] args) {
        int[][] ads = new int[][] {{6,9}, {9,11}, {11,14}, {14,18}};
        int[] effect = new int[] {9,10,6,7};
        System.out.println(getMaxEffectiveness(20, ads, effect));
        
    }
    
    private static int getMaxEffectiveness(int m, int[][] ads, int[] effect) {
        //check for max time
        int p = ads.length - 1;
        while(p > 0 && ads[p][1] > m) {
            p--;
        }
        //find the max effectiveness including and excluding an add
        int length = p+1;
        int[] include = new int[length];
        int[] exclude = new int[length];
        include[length - 1] = effect[length - 1];
        exclude[length - 1] = 0;
        for(int i = ads.length - 2;i >= 0; i--) {
            int endTime = ads[i][1];
            int nextEndTime = endTime + 4;
            int j = i + 1;
            int nextAdd = -1;
            while(j < ads.length && ads[j][1] < nextEndTime) {
                j++;
                nextAdd = j;
            }
            include[i] = Math.max((nextAdd==-1 || nextAdd++ >= length)?0:include[j], (nextAdd==-1 || nextAdd++ >= length)?0:exclude[j]) +  effect[i];
            exclude[i] = Math.max(include[i+1], exclude[i+1]);
        }
        return Math.max(include[0], exclude[0]);
    }

}
