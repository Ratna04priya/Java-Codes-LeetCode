//222. Count Complete Tree Nodes
//By Ratna Priya

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
