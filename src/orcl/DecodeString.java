package orcl;

import java.util.Stack;

/**
 * Given an encoded string, return its decoded string.
 * 
 * The encoding rule is: k[encoded_string], where the encoded_string inside the
 * square brackets is being repeated exactly k times. Note that k is guaranteed
 * to be a positive integer.
 * 
 * You may assume that the input string is always valid; No extra white spaces,
 * square brackets are well-formed, etc.
 * 
 * Furthermore, you may assume that the original data does not contain any
 * digits and that digits are only for those repeat numbers, k. For example,
 * there won't be input like 3a or 2[4].
 * 
 * Input: s = "3[a]2[bc]" Output: "aaabcbc"
 * 
 * @author SS057631
 *
 */
public class DecodeString {
	
    public static String decodeString(String s) {
    	if(s==null || s.length() == 1) return s;
    	
        StringBuilder res = new StringBuilder();
        Stack<Integer> counts = new Stack<Integer>();
        Stack<String> values = new Stack<String>();
        int index = 0;
        while(index < s.length()) {
        	if(Character.isDigit(s.charAt(index))) {
        		//there could be more than one digit in a number
        		int number = 0;
        		while(Character.isDigit(s.charAt(index))){
        			number = number * 10 + (s.charAt(index) - '0');
        			index++;
        		}
        		counts.add(number);
        	} else if(s.charAt(index) == ']') {
        		StringBuilder tempString = new StringBuilder();
        		while(!values.peek().equals("[")) {
        			tempString.append(values.pop());
        		}
        		values.pop();
        		int popNumber = !counts.isEmpty()?counts.pop():1;
        		String revString = tempString.reverse().toString();
        		StringBuilder tempBuilder = new StringBuilder();
    			for(int i=0;i<popNumber;i++) {
    				tempBuilder.append(revString);
    			}
    			values.push(tempBuilder.toString());
    			index++;
        	} else if(s.charAt(index) == '[') {
        		values.add(s.charAt(index)+"");
        		index++;
        	} else {
        		//put in the value stack till you get characters
        		while(index < s.length() && Character.isAlphabetic(s.charAt(index))) {
        			values.add(s.charAt(index)+"");
        			index++;
        		}
        	}
        }
        
        Stack<String> tempStack = new Stack<String>();
        while(!values.isEmpty()) {
        	tempStack.push(values.pop());
        }
        
        while(!tempStack.isEmpty()) {
        	res.append(tempStack.pop());
        }
        
        return res.toString();
    }

	public static void main(String[] args) {
		System.out.println(decodeString("3[a]2[bc]"));
		System.out.println(decodeString("3[a2[c]]"));
		System.out.println(decodeString("2[abc]3[cd]ef"));
	}

}
