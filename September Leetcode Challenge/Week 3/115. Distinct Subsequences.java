//115. Distinct Subsequences
//By Ratna Priya

class Solution {
    public int numDistinct(String s, String t) {
	char[] S= s.toCharArray(), P= t.toCharArray();
	int N= S.length, K= P.length, dp[]= new int[K];
	dp[0]= S[0]==P[0]?1:0;
	for(int i=1; i<N; ++i)
		for(int k=K-1; k>=0; --k)
			if(S[i]==P[k]) dp[k]+= k==0?1:dp[k-1];
	return dp[K-1];
}
}
