// 226. Invert Binary Tree
//By Ratna Priya

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        TreeNode r = new TreeNode(root.val);
        invert(root);
        return root;
    }
    public void invert(TreeNode root){
        if(root == null) return;
        TreeNode curr = root.left;
        root.left = root.right;
        root.right = curr;
        invert(root.left);
        invert(root.right);
    }
}
