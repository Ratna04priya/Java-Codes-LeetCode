// 125. Valid Palindrome
// By Ratna Priya

class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i =0; i<s.length(); i++){
            if((s.charAt(i) >='A' && s.charAt(i) <='Z') ||(s.charAt(i) >='a' && s.charAt(i) <='z' || (s.charAt(i)>='0' && s.charAt(i) <='9')) )
                sb.append(s.charAt(i));
            else continue;
        }
        
        String ss = sb.toString().toLowerCase();
        int i = 0;
        int j = ss.length() -1;
        while(i<=j){
            if(ss.charAt(i) != ss.charAt(j)) return false;
            else{
                i += 1;
                j -=1;
            }
        }
        return true;
    }
}
