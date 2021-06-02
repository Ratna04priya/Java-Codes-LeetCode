//14. Longest Common Prefix - https://leetcode.com/problems/longest-common-prefix/
//By Ratna Priya

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length ==1) return strs[0];
        StringBuilder s = new StringBuilder();
        
        int min = Math.min(strs[0].length(),strs[1].length());
        int j =0;
        while(j< min){
            if(strs[0].charAt(j) == strs[1].charAt(j))
            {   s.append(strs[0].charAt(j));
                j++;
            }
            else break;
        }
        if(s.length() == 0) return "";
        else{
        for(int i = 2; i<strs.length;i++){
            int k =0;
            StringBuilder temp = new StringBuilder();
            int min1 = Math.min(s.length(), strs[i].length());
            while(k< min1){
            if(strs[i].charAt(k) == s.charAt(k))
            {   temp.append(s.charAt(k));
                k++;
            }
            else break;
            }
            s = temp;
        }
            
            
        }
        return s.toString();
        
    }
}
