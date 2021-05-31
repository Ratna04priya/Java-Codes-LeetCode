//416. Partition Equal Subset Sum- https://leetcode.com/problems/partition-equal-subset-sum/
//By Ratna Priya

class Solution {
    public boolean canPartition(int[] nums) {
        int total =0;
        for(int i:nums){
            total +=i;
        }
        if(total%2 != 0) return false;
        
        return part(nums,0,0,total, new HashMap<String,Boolean>());
    }
    public boolean part(int[] nums, int index, int sum, int total, HashMap<String,Boolean> state){
        String current = index + "" + sum;
        if(state.containsKey(current)) return state.get(current);
        
        if(sum*2 == total) return true;
        
        if(sum> total/2 || index>= nums.length) return false;
        
        boolean found = part(nums, index+1, sum, total,state) || 
                        part(nums,index+1, sum+nums[index], total,state);
        state.put(current,found);
        return found;
    }
}
