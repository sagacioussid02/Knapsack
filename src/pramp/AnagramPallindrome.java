package pramp;

import java.util.HashSet;
import java.util.Set;

public class AnagramPallindrome {

	public static void main(String[] args) {
		System.out.println(AnagramPalindrome("aaab"));
	}
	
    public static boolean AnagramPalindrome(String word) {
        if(word == null) return false;
        int length = word.length();
        if(length == 1) return true;
        int count = 0;
        Set<Character> uniqueLetterSet = new HashSet<Character>();
        for(int i=0;i<length;i++){
            if(uniqueLetterSet.contains(word.charAt(i))){
            	uniqueLetterSet.remove(word.charAt(i));
                count--;
            } else{
                uniqueLetterSet.add(word.charAt(i));
                count++;
            }
        }
        if(length % 2 == 0){
            return count == 0;
        } else{
            return count == 1;
        }
    }

}
