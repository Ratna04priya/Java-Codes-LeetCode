// 129. Sum Root to Leaf Numbers
//By Ratna Priya 

class Solution {
    public int sumNumbers(TreeNode root) {
        return sum(root,0);
    }
    public int sum(TreeNode root, int s){
        if(root == null) return 0;
        s = s*10+ root.val;
        if(root.left == null && root.right == null)
            return s;
        else
            return sum(root.left, s)+sum(root.right,s);
    }
}
