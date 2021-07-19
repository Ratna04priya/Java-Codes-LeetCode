// 235. Lowest Common Ancestor of a Binary Search Tree
// By Ratna Priya

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	// BST, p's value is greater than roots, same for q's, so they go in same branch, continue the search
        if(p.val> root.val && q.val>root.val){
             return lowestCommonAncestor(root.right, p, q);
        }
			// BST, p's value is less than roots, same for q's, so they go in same branch, continue the search
        else if(p.val< root.val && q.val<root.val){
             return lowestCommonAncestor(root.left, p, q);
        }
		//whenever they part, is the common ancestor, return it.
        else{
            return root;
        }
        
    }
}
