// 598. Range Addition II
//By Ratna Priya

class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int rowMin = m;
        int colMin = n;
        
        for (int[] pair : ops) {
		   // Explanation - previous command said increment all from (0, 0) to (x, y)
		   // next command says increment all from (0, 0) to (p, q)
		   // how many max elements will be there ?
		   // min(x, p) * min(y, q)
		   
            rowMin = Math.min(rowMin, pair[0]);
            colMin = Math.min(colMin, pair[1]);
        }
        
        return rowMin * colMin;
    }
}
