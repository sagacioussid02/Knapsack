package algorithms.discussions;

import java.util.ArrayList;
import java.util.List;

public class LastSubstringInLexographicalOrder {

    public static void main(String[] args) {
        System.out.println(lastSubstring("abab"));
        System.out.println(lastSubstring("leetcode"));
        System.out.println(lastSubstring("leetcodecodecodetcodetcodeg"));
        System.out.println(lastSubstring("cacacb"));
    }
    
    public static String lastSubstring(String s) {
        
        //find the lexographically largest element
        List<Integer> indexes = new ArrayList<Integer>();
        char prev = s.charAt(0);
        char max ='\u0000';
        for(int i=1; i < s.length();i++){
            char curr = s.charAt(i);
            if(prev < curr){
                max = curr;
            } else{
                max = prev;
            }
            prev = max;
        }
        
        //get indexes of the largest element
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == max) indexes.add(i);
        }
        
        //get all the substrings starting from the indexes in the list
        //and compare with each other which will help in eliminating the other
        String maxStr=s.substring(indexes.get(0), s.length());;
        for(int i=1; i<indexes.size();i++){
            String currStr = s.substring(indexes.get(i), s.length());
            if(currStr.compareTo(maxStr) > 0){
                maxStr = currStr;
            }
        }
        return maxStr;
    }
    
    public String lastSubstringLeetCodeSol(String s) {
        
        int k = 0;
        int i = 0;
        int j = 1;
        int n = s.length();
        while(j+k < n)
        {
            // Continue till chars are same for two substrings
            if(s.charAt(i+k) == s.charAt(j+k)) k++;
            
            // substring indexed at i is smaller than substring at j , hence all substrings between i and j are smaller 
            // we jump i to j and increment j by 1
            else if (s.charAt(i+k) < s.charAt(j+k))
            {
                i = j;
                j++;
                k = 0;
            }
            
            // substring indexed at i is greater than substring at j ,
            // we jump j to j+k+1 to check if any further substring is greater than substring at i
            else if( s.charAt(i+k) > s.charAt(j+k))
            {
                
                j = j+k+1;
                k = 0;
            }
        }
             
        // finally we return the substring from index i which points to largest character in the string S
        return s.substring(i);            
    }

}
