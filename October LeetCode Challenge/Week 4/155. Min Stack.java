// 155. Min Stack
//By Ratna Priya

class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> min = new Stack<>();
    
    public MinStack() {}
    
    public void push(int val) {
        
        if( min.isEmpty() || val <= min.peek() ){
            min.push(val);
        }
        stack.push(val);
    }
    
    public void pop() {
            if (stack.peek().equals(min.peek())) {
            min.pop();
        }
       stack.pop();
        
    }
    
    public int top() {
         return stack.peek();
    }
    
    public int getMin() {
        return min.peek();
        
    }
}
