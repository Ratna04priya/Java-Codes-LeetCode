//35. Search Insert Position
//By Ratna Priya

class Solution {
    public int searchInsert(int[] nums, int target) {
        int l =0;
        int r = nums.length -1;
        int current =0;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(nums[mid] == target) return mid;
            else if(nums[mid]<target){
                current = mid+1;
                l = mid+1;
            }
            else{
                current = mid;
                r = mid -1;
            }
        }
        return current;
    }
}
