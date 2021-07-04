// 1220. Count Vowels Permutation
// By Ratna Priya 

class Solution {
    public int countVowelPermutation(int n) {
       long dp[][]=new long[n][5];
        for(int i=0;i<5;i++)
        {
            dp[0][i]=1L;
        }
         int MOD = 1000000007;
        for(int i=1;i<n;i++)
        {
            
                dp[i][0]=(dp[i-1][1]+dp[i-1][2]+dp[i-1][4])%MOD;
            dp[i][1]=(dp[i-1][0]+dp[i-1][2])% MOD;
            dp[i][2]=(dp[i-1][1]+dp[i-1][3])% MOD;
            dp[i][3]=(dp[i-1][2])% MOD;;
            dp[i][4]=(dp[i-1][2]+dp[i-1][3])% MOD;
            
        }
        long ans = 0L;
        for(int i=0;i<5;i++)
        {
            ans=(ans+dp[n-1][i])%MOD;
        }
        return (int)ans;
    }
}
