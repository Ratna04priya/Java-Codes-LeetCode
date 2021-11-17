//739. Daily Temperatures
//By Ratna Priya

class Solution {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[T.length];
        
        for(int i =T.length -1; i>=0; --i){
            while(!stack.isEmpty() && T[i] >=T[stack.peek()])
            {stack.pop();}
            res[i] = stack.isEmpty() ? 0: stack.peek() -i;
            stack.push(i);
        }
        return res;  
    }
}
