// 779. K-th Symbol in Grammar - recursion
// https://leetcode.com/problems/k-th-symbol-in-grammar/
//Input: N = 4, K = 5
//Output: 1     Explanation: row 1: 0 row 2: 01 row 3: 0110 row 4: 01101001

class Solution {

    public int kthGrammar(int N, int K) {
        if(N==1) return 0;
        int parent =  kthGrammar(N-1, K/2+K%2);
        boolean iskodd = false;
        if(K%2 ==1) iskodd = true;
        if(parent ==1){
            if(iskodd == true) return 1;
            else return 0;
        }
        else{
            if(iskodd == true) return 0;
            else return 1;
        }
      // return -1;
    }
}