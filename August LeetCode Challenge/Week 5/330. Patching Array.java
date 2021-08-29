//330. Patching Array
//By Ratna Priya

class Solution {
    public int minPatches(int[] nums, int n) {
        long R = 0;
        int i = 0;
        int added = 0;
        
        while(R < n){
            if(i < nums.length && nums[i] <= R  + 1){
                R = R + nums[i];
                i++;
            } else {
                R += (R + 1);
                added++;
            }
        }
        
        return added;
    }
}
