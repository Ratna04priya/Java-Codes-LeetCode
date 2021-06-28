//520. Detect Capital
//By Ratna Priya

class Solution {
    public boolean detectCapitalUse(String word) {
        int n = word.length();
        int upper = 0;
        for(int i =0; i<n; i++){
            if(word.charAt(i)>='A' && word.charAt(i)<='Z')
                upper++;
        }
        if(upper == 0 || upper == n|| word.charAt(0)>='A' && word.charAt(0)<='Z' && upper == 1)
            return true;
        else
            return false;
    }
}
