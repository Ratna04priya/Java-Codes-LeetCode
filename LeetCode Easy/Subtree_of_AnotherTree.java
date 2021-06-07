
// 572. Subtree of Another Tree
// https://leetcode.com/problems/subtree-of-another-tree/submissions/

/*
example 1
Given tree s:

     3
    / \
   4   5
  / \
 1   2
    /
   0


Given tree t:

   4
  / \
 1   2

Return false. 
*/


class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        
        if(s == null)
            return false;
        else if( isSameTree(s,t))
            return true;
        else
            return (isSubtree(s.left, t) || isSubtree(s.right,t));
        
    }
    
    public boolean isSameTree(TreeNode s, TreeNode t)
    {
        if(s == null || t == null)
            return s == null && t == null;
        else if(s.val == t.val)
            return (isSameTree(s.left, t.left) && isSameTree(s.right, t.right));
        else
            return false;
    }
}