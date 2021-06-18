// 222. Count Complete Tree Nodes
//Ratna Priya

class Solution {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;  
        if(root.right == null && root.left== null){
            return 1;
        }
        int l = countNodes(root.left);
        int r = countNodes(root.right);
        return 1+l+r;
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
