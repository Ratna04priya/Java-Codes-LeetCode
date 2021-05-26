 //124. Binary Tree Maximum Path Sum
 //https://leetcode.com/problems/binary-tree-maximum-path-sum/
 
 /* Definition for a binary tree node.
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
    int max_sum =0;
    public int maxPathSum(TreeNode root) {
        max_sum = Integer.MIN_VALUE;
        pathsum(root);
        return max_sum;   
    }
    public int pathsum(TreeNode root){
        if(root == null) return 0;
        int left = Math.max(0,pathsum(root.left));
        int right = Math.max(0,pathsum(root.right));
        max_sum = Math.max(max_sum, left+right+root.val);
        return Math.max(left,right)+ root.val;
    }
   
}
