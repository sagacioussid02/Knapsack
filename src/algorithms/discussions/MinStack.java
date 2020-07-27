package algorithms.discussions;

/**
 * Write a getMin() function to output minimum value in the stack
 * 
 * Algo:- To keep track of minimum value in the stack there should be a variable which 
 * stores the minimum value so far while pushing. But, while popping the previous min value should 
 * be calculated if the popped item is equal to min value. So, to keep track of that, there should be 
 * some kind of relationship between the numbers which are getting pushed and the variable where minValue is stored.
 * To do that, while pushing, instead of using the value to be pushed into stack we push twice of that value - the current minimum
 * which gives the value which has the previous minValue data and then update the min value. Let's see how:
 * 
 *   x : Value to be pushed
 * minValue : min value so far
 * 
 * If value to be pushed is less than the min value, then the push value is = 2 * x - minValue
 * Here we encapsulated previous minValue in the value to be pushed which will help in extracting the previous
 * min value if the min value is popped from the stack. How to get to this equation:
 * 
 * So, the goal is to update min value when the value to be pushed is less than min value
 * which implies, x < minValue => (2 * x) < (2 * minValue) => (2 * x) < minValue + minValue => (2 * x) - minValue < minValue
 * 
 * Since, we are pushing a value less then minValue, the new calculated value is also less than minValue and it has hidden previous
 * minValue. So, we are good while pushing this. But, while popping we need to extract the prev min value.
 * This implies, (2 * x) - prevMinValue = currentMinValue => (2 * x) - currentMinValue = prevMinValue.
 * 
 * All good, but there is one more hindrance in getting the x from the stack as the value of x while popping is also not clear.
 * In that case x will be the current value of minValue which is the min number to be pushed into the stack at that point.
 * 
 * @author SS057631
 *
 */
public class MinStack {
    
    private int[] arr;
    private int count;
    private int minValue;
    
    public MinStack() {
        arr = new int[10];
        count = -1;
        minValue = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if(count == -1) {
            minValue = val;
            arr[++count] = val;
        }
        else if(minValue <= val) arr[++count] = val;
        else {
            int push = (2 * val) - minValue;
            arr[++count] = push;
            minValue = val;
        }
    }
    
    public int pop() {
        if(arr[count] >= minValue) return arr[count--];
        else {
            int popValue = minValue;
            minValue = (2 * popValue) - arr[count];
            return popValue;
        }
    }
    
    public int getMin() {
        return minValue;
    }
    
    public int peek() {
        return arr[count];
    }
}
