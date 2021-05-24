// 98. Validate Binary Search Tree - https://leetcode.com/problems/validate-binary-search-tree/
// By Ratna Priya


class Solution {
    public boolean isValidBST(TreeNode root) {
       return validate(root, null, null);
    }
    public boolean validate(TreeNode root, Integer max, Integer min){
        if(root == null) return true;
        else if(max !=null && root.val>=max ||min != null && root.val<= min)
            return false;
        else
            return validate(root.left, root.val, min) && validate(root.right, max, root.val);
    }

}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
