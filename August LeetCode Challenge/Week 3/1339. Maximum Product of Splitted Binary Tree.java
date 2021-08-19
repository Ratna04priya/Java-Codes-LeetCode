 //1339. Maximum Product of Splitted Binary Tree
//By Ratna Priya

class Solution {
    long max = 0;
    public int maxProduct(TreeNode root) {
    //sum contains the sum of all nodes in the tree
    long sum = findSum(root);
    
    func(root , sum);
    
    //take care of brackets. first MOD of long then convert to integer
    return (int)(max % 1000000007);
}

//this function finds max product of 2 sums in the tree
public long func(TreeNode root, long sum){
    if(root==null){
        return 0;
    }
    long left = func(root.left,sum);
    long right = func(root.right,sum);
    long curr = left + right + root.val;
    max = Math.max(max , curr * (sum - curr));
    return curr;
}

//this function is get total of all nodes in the tree
public long findSum(TreeNode root){
    if(root == null){
        return 0;
    }
    long left = findSum(root.left);
    long right = findSum(root.right);
    return left+right+root.val;
}
}
