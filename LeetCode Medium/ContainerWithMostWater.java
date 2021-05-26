//11. Container With Most Water
//https://leetcode.com/problems/container-with-most-water/
//Input: height = [4,3,2,1,4]
//Output: 16

import java.lang.*;
class Solution {
    public int maxArea(int[] height) {
        int maxarea = 0;
        int minh = 0;
        int i = 0;
        int j = height.length -1;
        
        while(i<j){
            minh = Math.min(height[j],height[i]);
            maxarea = Math.max(maxarea, minh*(j-i));
            if(height[i]<height[j]){
                i++;
            }
            else{
                j--;}
        }
        return maxarea;
    }
}