//735. Asteroid Collision - https://leetcode.com/problems/asteroid-collision/
//By Ratna Priya

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while(i<asteroids.length){
            if(asteroids[i]>0) stack.push(asteroids[i]);
            else{
                while(!stack.isEmpty() && stack.peek()>0 && stack.peek()< Math.abs(asteroids[i]))
                {
                    stack.pop();
                }
                if(stack.isEmpty() || stack.peek()<0)
                {
                    stack.push(asteroids[i]);
                }
                else if(stack.peek() == Math.abs(asteroids[i]))
                {
                    stack.pop();
                }
            }
            i++;
        }
        int[] result = new int[stack.size()];
        for(int j = stack.size()-1; j>=0; j--){
            result[j] = stack.pop();
        }
        return result;
    }
}
