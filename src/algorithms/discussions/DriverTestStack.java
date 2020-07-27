package algorithms.discussions;

class DriverTestStack{
    
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(3);
        minStack.push(5);
        minStack.push(2);
        minStack.push(1);
        minStack.push(-1);
        
        System.out.println(minStack.getMin());
        
    }
}
