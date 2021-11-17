//368. Largest Divisible Subset
//By Ratna Priya 

class Solution {
    public List<Integer> largestDivisibleSubset(int[] A) {
        
     
        if(A.length == 0) return new ArrayList<>();
        
        List<Integer> ans = new ArrayList<>();
       
            
        Arrays.sort(A);
        int N = A.length;
        int[] lis = new int[N];
        
        lis[0] = 1;
        
        int max = 1;
        
        
        for(int i = 1 ; i < N; i++)
        {
            lis[i] = 1;
            
            for(int j = 0; j < i; j++)
            {
              if(A[i] % A[j] == 0)
              {
                lis[i] = Math.max(lis[i], lis[j] + 1);
                max = Math.max(max, lis[i]); 
              }
            }
        }
        
        int maxEle = -1;
        
        for(int i = N - 1; i >= 0; i--)
        {
           if(max == lis[i]) 
           {
               if(maxEle == -1)
               {
                  ans.add(A[i]);
                  maxEle = A[i];
                  max--;
               }
               else if(maxEle % A[i] == 0)
               {
                   ans.add(A[i]);
                   maxEle = A[i];
                   max--;
               }
               
           }
        }
        
        return ans;
    }
}
