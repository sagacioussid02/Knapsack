package orcl;

import java.util.Stack;

public class ReversePolishNotation {
	
    public static int evalRPN(String[] tokens) {
    	//you need only one stack to push the numbers
        Stack<Integer> operandStack = new Stack<Integer>();
        int index = 0;
        while(index < tokens.length){
            try{
               //check is string is a number by using Integer.parseInt which throws exception if the string is not a number
               int num = Integer.parseInt(tokens[index]); 
               operandStack.push(num);
                index++;
            } catch(NumberFormatException ex){
                //pop two items from operand stack and then push it back
                int num1 = operandStack.pop();
                int num2 = operandStack.pop();
                String operator = tokens[index++];
                int operationValue =  performOperation(num1,num2, operator); 
                operandStack.push(operationValue);
            }
        }
        return operandStack.pop();
    }
    
    public static int performOperation(int num1, int num2, String operator){
        switch(operator){
            case "+":
                return num1+num2;
            case "-":return num2-num1;
            case "/":return num2/num1;
            case "*":return num1*num2;
            default:
                break;
        }
        return -1;
    }

	public static void main(String[] args) {
		String[] tokens = {"4","13","5","/","+"};
		System.out.println(evalRPN(tokens));
	}

}
