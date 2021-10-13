//1008. Construct Binary Search Tree from Preorder Traversal
//By Ratna Priya

class Solution {
    TreeNode root;
    public TreeNode bstFromPreorder(int[] preorder) {
        for(int n : preorder){
            add(n);
        }
        return root;
    }
    void add(int n){
        root = add(root,n);
    }
    private TreeNode add(TreeNode root, int n){
        if(root == null){
            return new TreeNode(n);
        }
        if(root.val > n){
            root.left = add(root.left, n);
        }
        if(root.val < n){
             root.right = add(root.right, n);
        }
        return root;
    }
}
