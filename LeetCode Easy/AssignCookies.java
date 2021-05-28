
// 455. Assign Cookies
// https://leetcode.com/problems/assign-cookies/

/*
Input: g = [1,2,3], s = [1,1]
Output: 1
Explanation: You have 3 children and 2 cookies. The greed factors of 3 children are 1, 2, 3. 
And even though you have 2 cookies, since their size is both 1, you could only make the child whose greed factor is 1 content.
You need to output 1.
*/

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int count = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int i = g.length -1;
        int j = s.length -1;
        
        while(i >=0 && j >=0)
        {
            if(s[j] >= g[i])
            {
                count++;
                i--;
                j--;
            }
            else
            {   i--; }
        }
        