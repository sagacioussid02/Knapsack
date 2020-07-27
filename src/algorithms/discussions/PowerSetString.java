package algorithms.discussions;

import java.util.ArrayList;
import java.util.List;

public class PowerSetString {
    
    static List<String> res = new ArrayList<String>();
    public static List<String> powerSet(String str){
        recursionHelper(str,-1, "" );
        return res;
    }
    
    public static void recursionHelper(String inputString, int index, String newString) {
        //base condition
        if(index == inputString.length()) return;
        
        //add the new String to the list came from last stack
        res.add(newString);
        
        //iterate over the indexes starting from current index
        for(int i = index + 1; i < inputString.length(); i++) {
            //create new String
            newString += inputString.charAt(i);
            //call it recursively
            recursionHelper(inputString, i, newString);
            //after recursion, perform backtracking
            newString = newString.substring(0, newString.length() - 1);
        }        
    }

    public static void main(String[] args) {
        powerSet("abc").stream().forEach(System.out::println);;
    }

}
