// 363. Max Sum of Rectangle No Larger Than K
// By Ratna Priya

class Solution {
    public int maxSumSubmatrix(int[][] matrix, int x) {
        int m=matrix.length,n=matrix[0].length;
        int maxSum=Integer.MIN_VALUE;
        int[] sumArr=new int[n];
		// traversing each rectangle and sumArr will keep track of all previous rectangle sum.
         for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    Arrays.fill(sumArr,0);
                    int tmpSum=0;
                    for(int k=i;k<m;k++){
                        int rowTmpSum=0;//keep track of current row sum till previous element
                        for(int l=j;l<n;l++){
                            if(l==j && i==k){
							// if the first element of rectangle,just add the first element  
                                rowTmpSum=matrix[k][l];
                                tmpSum=rowTmpSum;
                            }else{
							// else current rowsum equals previous rowsum+current element
                                rowTmpSum=rowTmpSum+matrix[k][l];
                                tmpSum=rowTmpSum+sumArr[l];
                            }
                            sumArr[l]=tmpSum;
                        if(tmpSum<=x){
                            maxSum=Math.max(maxSum,tmpSum);
                            if(maxSum==x){
                                return maxSum;
                            }
                        }
                    }
                }
            }
        }
        return maxSum;
    }
}
