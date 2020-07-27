package algorithms.companies.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HighFive {

    public static void main(String[] args) {
        int[][] items = new int[][]{{1,91},{1,92},{2,93},{2,97},{1,60},{2,77},{1,65},{1,87},{1,100},{2,100},{2,76}};
        /*
         * items[0][0] = 1; items[0][1] = 91; items[1][0] = 1; items[1][1] = 92; items[2][0] = 2; items[2][1] = 91;
         * items[3][0] = 1; items[3][1] = 60; items[4][0] = 1; items[4][1] = 65; items[5][0] = 2; items[5][1] = 98;
         * items[6][0] = 1; items[6][1] = 87; items[7][0] = 2; items[7][1] = 95;
         */
        
        
        
        highFive(items);
    }
    
    public static int[][] highFive(int[][] items) {
        
        //HashMap with key as Id and value as Priority Queue of marks
        final Map<Integer, PriorityQueue<Integer>> idByMarks = new HashMap<Integer, PriorityQueue<Integer>>();
        for(int i=0;i<items.length;i++){
                if(idByMarks.containsKey(items[i][0])){
                    PriorityQueue<Integer> qu = idByMarks.get(items[i][0]);
                    qu.offer(items[i][1]);
                    idByMarks.put(items[i][0],qu); 
                } else{
                   PriorityQueue<Integer> qu = new PriorityQueue<Integer>(
                       (e1, e2) -> {
                           return e2 - e1;
                       }
                   );
                   qu.offer(items[i][1]);
                   idByMarks.put(items[i][0],qu); 
                }  
            }
            
            int sizeResult = idByMarks.size();
            int[][] result = new int[sizeResult][2];
            int stuId = 0;
            
            for(Map.Entry<Integer,PriorityQueue<Integer>> each:idByMarks.entrySet()){
                int id = each.getKey();
                PriorityQueue<Integer> marksQueue = each.getValue();
                double avg = getAvg(marksQueue);
                result[stuId][0] = id;
                result[stuId][1] = (int)avg;
                stuId++;
            }
            return result;
        }
    
    public static double getAvg(final PriorityQueue<Integer> qu){
        int count = 1;
        int size = qu.size();
        int sum = 0;
        while(count <= 5 && count <= size){
            sum += (int)qu.remove();            
            count++;
        }
        
        return sum/(count - 1);
    }

}
