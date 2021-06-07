//101. Symmetric Tree
//https://leetcode.com/problems/symmetric-tree/

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
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root== null) return true;
        return check(root.right, root.left);
    }
    public boolean check(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null) return true;
        else if(root1!= null && root2 != null && root1.val == root2.val)
            return check(root1.left, root2.right) && check(root1.right, root2.left);
        else
            return false;
    }
}