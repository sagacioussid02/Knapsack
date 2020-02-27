package pramp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class PowerSet {

	public static void main(String[] args) {
		System.out.println(powerSet("abc"));
	}
	
    public static List<String> powerSet(String inputStr) {
        PriorityQueue<String> powerSet = new PriorityQueue<String>();
        for(int i=0;i<inputStr.length()-1;i++){
            for(int j=i+1;j<inputStr.length();j++){
                powerSet.add(inputStr.substring(i, j));
            }
        }

        List<String> res = new ArrayList<String>();
        for(String each:powerSet){
            res.add(each);
        }
        return (List<String>)res;
    }

}
