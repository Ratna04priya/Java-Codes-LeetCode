// String Compression
// https://leetcode.com/problems/string-compression/

/*
Input: chars = ["a","a","a","b","b","a","a"]
Output: Return 6, and the first 6 characters of the input array should be: ["a","3","b","2","a","2"].
Explanation: The groups are "aaa", "bb", and "aa". This compresses to "a3b2a2". Note that each group is independent even if two groups have the same character.

*/

class Solution {
    public int compress(char[] chars) {
        
        int index = 0;
        int i = 0;
        while(i< chars.length)
        {
            int j = i;
            while(j < chars.length && chars[j] == chars[i])
            {
                j ++;
            }
            chars[index++] = chars[i];
            if(j - i > 1)
            {
            String count = j-i + "";
            for(char c : count.toCharArray())
            { 
             chars[index++] = c;
            
            }
        }
            i = j;
        }
        System.out.println(index);
        return index;
    }
}
