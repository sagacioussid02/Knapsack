package orcl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnagramsInAString {

	public static void main(String[] args) {
		String input2= "aa";
		String input1 = "aaa";
		System.out.println(anagramIndexes(input1,input2));
	}
	
private static List<Integer> anagramIndexes(String input1,String input2){
        
        int[] countsExpected=new int[26];
        for(char ch:input2.toCharArray()){
            countsExpected[ch-'a']+=1;
        }
        int[] countsActual=new int[26];
        int i=0;
        int j=0;
        List<Integer> results=new ArrayList<>();
        while(j<input1.length()){
            countsActual[input1.charAt(j)-'a']+=1;
            if(countsActual[input1.charAt(j)-'a'] == countsExpected[input1.charAt(j)-'a']){
                if(j-i+1==input2.length()){
                    results.add(i);
                    countsActual[input1.charAt(i)-'a']-=1;
                    i=i+1;
                }
            }else if(countsActual[input1.charAt(j)-'a']>countsExpected[input1.charAt(j)-'a']){
                if(countsExpected[input1.charAt(j)-'a']==0){
                    i=j+1;
                    Arrays.fill(countsActual, 0);
                }else{
                    while(i<=j){
                        countsActual[input1.charAt(i)-'a']-=1;
                        if(input1.charAt(i)==input1.charAt(j)){
                            i++;
                            break;
                        }
                        i++;
                    }   
                }
            }
            j++;
        }
        
        return results;
    }

}
