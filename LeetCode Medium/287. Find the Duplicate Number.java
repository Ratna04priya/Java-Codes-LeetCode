// 287. Find the Duplicate Number
// by Ratna Priya
// 2 pointer solution in Array
// Time Complexity - O(N), Space Complexity - O(1)

class Solution {
    public int findDuplicate(int[] nums) {
        if(nums.length ==0) return 0;
        int slow = nums[0];
        int fast = nums[0];
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
            
        }while(slow != fast);
        
            fast = nums[0];
        while(fast != slow){
            fast = nums[fast];
            slow = nums[slow];
        }
        return fast;
    }
}
