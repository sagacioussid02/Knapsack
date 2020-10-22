package algorithms.discussions;

import java.util.Stack;

public class ReverseSubstringsBetweenParantheses {
	
	//Time Complexity: O(m*n)
	//Space Complexity:O(m*n)
    public static String reverseParentheses(String s) {
        Stack<Character> stack = new Stack<Character>();
        
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == ')'){
            	StringBuilder str = new StringBuilder();
                while(!stack.isEmpty() && !stack.peek().equals('(')){
                	char pop = stack.pop();
                    if(pop != '(') {
                    	str.append(pop);
                    }
                }
                stack.pop();
                for(int j=0;j<str.toString().length();j++) {
                	stack.push(str.toString().charAt(j));
                }
                
            } else{
                stack.push(s.charAt(i));
            }
        }
        
        //convert stack to String
        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty()) {
        	res.append(stack.pop());
        }
        
        return res.reverse().toString();
    }
    
    public static String reverseParenthesesOptimized(String inputString) {
    	StringBuilder str = new StringBuilder(inputString);
    	int start, end;
    	while(str.indexOf("(") != -1){
    		start = str.lastIndexOf("(");
    		end = str.indexOf(")", start);
    		str.replace(start, end + 1, new StringBuilder(str.substring(start+1, end)).reverse().toString());
    	}
    	return str.toString();
    }

	public static void main(String[] args) {
		String str = "(u(love)i)";
		System.out.println(reverseParentheses(str));
	}

}
