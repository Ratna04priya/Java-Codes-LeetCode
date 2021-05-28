
// 1221. Split a String in Balanced Strings
// https://leetcode.com/problems/split-a-string-in-balanced-strings/

/*
Input: s = "RLRRLLRLRL"
Output: 4
Explanation: s can be split into "RL", "RRLL", "RL", "RL", each substring contains same number of 'L' and 'R'.

*/
class Solution {
    public int balancedStringSplit(String s) {
        int balanceCount = 0;
        int count = 0;
        for(int i =0; i< s.length(); i++)
        {
            char current = s.charAt(i);
            if(current =='L')
            { count ++;}
            
            if(current =='R')
            { count --;}
            
            if(count == 0)
            {
                balanceCount +=1;
            }
        }
        return balanceCount;
    }
}
