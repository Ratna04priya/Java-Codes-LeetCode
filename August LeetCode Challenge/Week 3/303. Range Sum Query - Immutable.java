//303. Range Sum Query - Immutable
//By Ratna Priya

class NumArray {
    int prefix[];
    public NumArray(int[] nums) {
        prefix = new int [nums.length];
        for(int i=0;i<nums.length;i++){
            prefix[i] = nums[i];
            if(i>0){
                prefix[i] += prefix[i-1];
            }
        }
    }
    
    public int sumRange(int left, int right) {
        int sum = prefix[right];
        if(left != 0){
            sum -= prefix[left-1];
        } 
        return sum;
    }
}
