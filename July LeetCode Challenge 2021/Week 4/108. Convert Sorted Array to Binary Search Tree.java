// 108. Convert Sorted Array to Binary Search Tree
// By Ratna Priya

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {

        return nums.length>0 ? rec(0, nums.length-1, nums): null;
    }

    private TreeNode rec(int l , int r, int[] nums){
        if(l==r)
            return new TreeNode(nums[l]);
        
        int mIdx= (l+r)/2;
        TreeNode mid = new TreeNode(nums[mIdx]);
        if(mIdx>l)
            mid.left = rec(l,mIdx-1, nums);
        if(mIdx<r)
            mid.right = rec(mIdx+1, r, nums);
        
        return mid;
    }
}
