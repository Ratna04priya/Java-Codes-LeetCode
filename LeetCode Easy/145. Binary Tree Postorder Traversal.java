// 145. Binary Tree Postorder Traversal - https://leetcode.com/problems/binary-tree-postorder-traversal/
// By Ratna Priya
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode current = stack.pop();
            result.add(0,current.val);
            if(current.left != null) stack.push(current.left);
            if(current.right != null) stack.push(current.right);
        }
        return result;
        }
}
