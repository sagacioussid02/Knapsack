package algorithms.concepts;

import java.util.HashMap;
import java.util.Map;

public class ExceptionHandling {

    public static void main(String[] args) {
    	Map<Integer, Integer> myMap = new HashMap<Integer, Integer>();
    	Integer val = myMap.get(null);
    	System.out.println("null value  ="+val);
		/*
		 * for(int i = 0; i < 10; i++) { try { if(i %2 == 0)
		 * System.out.println("edlkdl"); else throw new Exception(); } catch(Exception
		 * ex) { System.out.println("exception"); } }
		 */

    }

}
