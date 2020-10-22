package orcl;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Implement a basic calculator to evaluate a simple expression string.
 * 
 * The expression string contains only non-negative integers, +, -, *, /
 * operators and empty spaces . The integer division should truncate toward
 * zero.
 * 
 * @author SS057631
 *
 */
public class BasicCalculator2 {
	
    public static int calculateLeetcodeSol(String s) {

        int len = s.length();
        if (s == null || len == 0) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int currentNumber = 0;
        char operation = '+';
        for (int i = 0; i < len; i++) {
            char currentChar = s.charAt(i);
            if (Character.isDigit(currentChar)) {
                currentNumber = (currentNumber * 10) + (currentChar - '0');
            }
            if (!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar) || i == len - 1) {
                if (operation == '-') {
                    stack.push(-currentNumber);
                }
                else if (operation == '+') {
                    stack.push(currentNumber);
                }
                else if (operation == '*') {
                    stack.push(stack.pop() * currentNumber);
                }
                else if (operation == '/') {
                    stack.push(stack.pop() / currentNumber);
                }
                operation = currentChar;
                currentNumber = 0;
            }
        }
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }
	
	public static int calculate(String s) {
    	//this is most likely evaluating an infix expresion
    	//we will maintain two stacks one for operand and other for operator
    	Stack<String> operandStack = new Stack<String>();
    	Stack<Character> operatorStack = new Stack<Character>();
    	String str = s.trim().replaceAll(" ", "");
    	
    	//iterate through each character in the String
    	for(int i=0;i<str.length();i++) {
    		char ch = str.charAt(i);
    		if(Character.isDigit(ch)) {
                int num = 0;
                while(Character.isDigit(str.charAt(i))){
                	num = num * 10 + (str.charAt(i) - '0');
                    i++;
                }
    			operandStack.push(num+"");
    			i--;
    		} else {
    			//if operator stack is empty then push it directly
    			if(operatorStack.isEmpty()) {
    				operatorStack.push(ch);
    			} else {
    				//if it is not empty then check the priority
    				if(isHigherOrEqualPriority(ch, operatorStack)) {
    					//if higher or equal priority then push it to the stack
    					operatorStack.push(ch);
    				} else {
    					//process the values and push it back to the stack
    					process(operatorStack, operandStack);
    				}
    			}
    		}
    	}
    	
    	while(!operatorStack.isEmpty()) {
    		process(operatorStack, operandStack);
    	}
    	
        return Integer.parseInt(operandStack.pop());
    }
    
    private static void process(Stack<Character> operatorStack, Stack<String> operandStack) {
    	//this involves 3 steps
    	//1. pop two items out of operand stack
    	//2. pop one item from the operator stack
    	//3. Evaluate and push the result back to operand stack
    	int a = Integer.parseInt(operandStack.pop());
    	int b = Integer.parseInt(operandStack.pop());
    	char operator = operatorStack.pop();
    	String pushToStack;
    	switch(operator) {
    		case '+':
    			pushToStack = ((a+b)+"");
    			operandStack.push(pushToStack);
    			break;
    		case '-':
    			pushToStack = ((a-b)+"");
    			operandStack.push(pushToStack);
    			break;
    		case '*':
    			pushToStack = ((a*b)+"");
    			operandStack.push(pushToStack);
    			break;
    		case '/':
    			pushToStack = ((b/a)+"");
    			operandStack.push(pushToStack);
    			break;
    		default:
    			return;
    	}
	}

	private static boolean isHigherOrEqualPriority(char operator, Stack operatorStack) {
    	Map<Character,Integer> priorityMap = new HashMap<Character, Integer>();
    	priorityMap.put('+', 1);
    	priorityMap.put('-', 1);
    	priorityMap.put('*', 2);
    	priorityMap.put('/', 2);
    	return priorityMap.get(operatorStack.peek()) <= priorityMap.get(operator);
    	
    }

	public static void main(String[] args) {
		//alculate("384/2");
		calculateLeetcodeSol("384+6/2");
	}

}
