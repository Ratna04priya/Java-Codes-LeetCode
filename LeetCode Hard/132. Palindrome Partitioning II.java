//132. Palindrome Partitioning II
//By Ratna Priya

class Solution {
    int minimum = Integer.MAX_VALUE;
    public int minCut(String s) {
      int dp[][] = new int[s.length()+1][s.length()+1]; 
        for(int row[] : dp)
            Arrays.fill(row,-1);
   int minimum =   helper(s,dp,0,s.length()-1);
       return minimum; 
    }
    
    int helper(String s,int dp[][],int l,int m){
       if(l>=m){
          return 0;
       }
         
        if(isPalindrome(s,l,m)){
        dp[l][m]=0;
        return 0;
    }
       if(dp[l][m] != -1)
            return dp[l][m];
     
        int min = Integer.MAX_VALUE;
    for(int i = l;i<=m;i++){
       
        if(isPalindrome(s,l,i)){
        
           int par = 1+helper(s,dp,i+1,m);
           min = Math.min(min,par);
        }
        
    }
        return   dp[l][m]= min;
    
}

boolean isPalindrome(String s,int l,int m){ 
    int i =l;
   int  j=m;
    while(i<j){
        if(s.charAt(i) == s.charAt(j)){
            i++;
            j--;
        }
        else 
        {
            return false;
        }
    }
    
    
    return true;
    
}
}
