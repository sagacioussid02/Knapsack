package orcl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Input: s = "12" Output: 2 Explanation: It could be decoded as "AB" (1 2) or
 * "L" (12).
 * 
 * @author SS057631
 *
 */
public class DecodeWays {
	
    HashMap<Integer, Integer> dp = new HashMap<Integer, Integer>();
    public int numDecodingsLeetCodeSolution(String s) {
        if(s == null || s.length() == 0) return 0;
        return recursionHelperLeetcodeSolution(0,s);
    }
    
    public int recursionHelperLeetcodeSolution(int pos, String s){
        if(pos == s.length() || pos == s.length() -1){
            return 1;
        }
        
        if(s.charAt(pos) == '0'){
            return 0;
        }
        
        if(dp.containsKey(pos)){
            return dp.get(pos);
        }
        
        int ans = recursionHelperLeetcodeSolution(pos+1, s);
        if(Integer.parseInt(s.substring(pos,pos+2)) <= 26){
            ans += recursionHelperLeetcodeSolution(pos+2, s);
        }
        
        dp.put(pos, ans);
        return ans;
    }
	
    public static int numDecodings(String s) {
        if(s == null) return 0;
        List<String> resultList = new ArrayList<>();
        recursionHelper(s,0,resultList,"");
        System.out.println(resultList.size());
        return resultList.size();
    }

	private static void recursionHelper(String s, int pos, List<String> resultList, String curr) {
		
		//if we reach to the end of the string then add it to resultlist
		if(pos == s.length()) {
			resultList.add(curr);
			return;
		}
		
		//currentString = currentString + s.charAt(pos);
		//with every node there will be two branches
		//one with considering single digit and other one with single digit
		//take one out and add it to locallist
		 int num = Integer.parseInt("" + s.charAt(pos));
		 recursionHelper(s, pos+1, resultList, curr+ (char)(96 + num));
		 
		 if(pos == s.length()-2) {
			 recursionHelper(s, pos+2, resultList, curr+ (char)(96 + Integer.parseInt(s.substring(pos))));  	
		 }
		 else if( pos < s.length()-2 && Integer.parseInt(s.substring(pos,pos+2)) <= 26) {
			 recursionHelper(s, pos+2, resultList, curr+ (char)(96 + Integer.parseInt(s.substring(pos,pos+2))));  			 
		 }
	}
	


	public static void main(String[] args) {
	        List<String> resultList = new ArrayList<>();
	        recursionHelper("223",0,resultList,"");
	        for(String s : resultList) {
	        	System.out.println(s);
	        }
	        System.out.println(resultList.size());
	       
	}

}
