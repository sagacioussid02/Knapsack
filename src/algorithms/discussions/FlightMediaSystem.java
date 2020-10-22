package algorithms.discussions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class FlightMediaSystem {

    public static void main(String[] args) {
        idsOfMovies(60, 5, Arrays.asList(16,20,30,14,10));
    }
    
    public static List<Integer> idsOfMovies(int flightDuration, int numMovies, List<Integer> movieDuration){
        if(numMovies < 2) return null;
        int durationSum = flightDuration - 30;
        if(numMovies == 2 && movieDuration.get(0) + movieDuration.get(1) != durationSum) return null;
        
        PriorityQueue<List<Integer>> pairs =  new PriorityQueue<List<Integer>>((a,b)-> { 
            int sumA = a.get(0) + a.get(1);
            int sumB = b.get(0) + b.get(1);
            return sumB - sumA;
        });
        Map<Integer, Integer> complimentSum = new HashMap<Integer,Integer>();
        for(int i=0;i<movieDuration.size();i++) {
            int duration = movieDuration.get(i);
            if(complimentSum.containsKey(duration)) {
                pairs.add(Arrays.asList(i, complimentSum.get(duration)));
            } else {
                complimentSum.put(durationSum - duration, i);
            }
        }
        return pairs.remove();
    }

}
