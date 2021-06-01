//113. Path Sum II - https://leetcode.com/problems/path-sum-ii/
//By Ratna Priya

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> paths = new ArrayList<>();
        findpath(root, targetSum, new ArrayList<Integer>(), paths);
        return paths;
    }
    public void findpath(TreeNode root, int sum, ArrayList<Integer> current,List<List<Integer>> paths ){
        if(root == null) return;
        current.add(root.val);
        
        if(root.val == sum && root.left == null && root.right == null){
            paths.add(current);
            return;
        }
        findpath(root.left, sum-root.val, new ArrayList<Integer>(current), paths);
        findpath(root.right, sum-root.val, new ArrayList<Integer>(current), paths);
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
