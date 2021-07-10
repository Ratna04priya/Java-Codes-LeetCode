//300. Longest Increasing Subsequence
//By Ratna Priya

class Solution {
    public int lengthOfLIS(int[] a) {
        int[] lis = new int[a.length];
        for(int i = 0; i< a.length; i++){
            lis[i] =1;
        }
        int maxlis = 1;
        for(int i = 1; i<lis.length;i++){
            for(int j = 0; j<i; j++){
                if(a[i]>a[j] && 1+lis[j]>lis[i]){
                    lis[i] = lis[j] +1;
                    maxlis = Math.max(maxlis,lis[i]);
                }
            }
        }
        return maxlis;
    }
