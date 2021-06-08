//392. Is Subsequence - https://leetcode.com/problems/is-subsequence/
// Ratna Priya
class Solution {
    public boolean isSubsequence(String s, String t) {
        int i=0;
        int j =0;
        if(s.length()==0) return true;
        while(i<s.length() && j< t.length()){
            if(s.charAt(i) == t.charAt(j)){
                if(i == s.length()-1) return true;
                else{
                i++;
                j++;}
            }
            else j++;
            
        }
        return false;
    }
}
