
//543. Diameter of Binary Tree
//by Ratna Priya


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
    class pair{
        int height;
        int dia;
    }
   //at any node we need four information, height of left and right ,  diameter of left and right.
  
    public int diameterOfBinaryTree(TreeNode root) {
        return diameter2(root).dia;
    }
    
    pair diameter2(TreeNode node){
        if(node == null){
            pair bres = new pair();
            bres.height = -1;
            bres.dia = 0;
            return bres;
        }
        pair lp = diameter2(node.left);
        pair rp = diameter2(node.right);
        
        pair mp = new pair();
        mp.height = Math.max(lp.height , rp.height) + 1;
        
        mp.dia = Math.max(lp.height + rp.height + 2 , Math.max(lp.dia , rp.dia));
        
        return mp;
    }
}
