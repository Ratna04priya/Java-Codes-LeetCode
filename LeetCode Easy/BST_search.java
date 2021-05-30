
// 938. Range Sum of BST
//https://leetcode.com/problems/range-sum-of-bst/
/*Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
Output: 32*/


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
    public int rangeSumBST(TreeNode root, int L, int R) {
        int sum = 0;
        if(root == null){
            return sum;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode current = queue.remove();
            if(current.val >= L && current.val <=R){
                sum += current.val;
            }
            if(current.left != null && current.val > L){
                queue.add(current.left);
            }
            if(current.right != null && current.val < R){
                queue.add(current.right);
            }
        }
        return sum;
    }
}