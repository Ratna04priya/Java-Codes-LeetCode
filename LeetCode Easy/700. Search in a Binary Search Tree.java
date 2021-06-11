//700. Search in a Binary Search Tree
//By Ratna Priya

class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null) return null;
        if(val == root.val) return root;
        else if(val<root.val) return searchBST(root.left, val);
        else return searchBST(root.right,val);
    }
}
