// Problem Statement: https://leetcode.com/problems/delete-nodes-and-return-forest/
// By Ratna Priya

class Solution {
    
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> result = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for(int i : to_delete){
            set.add(i);
        }
        dfs(root, set, result);
        if(!set.contains(root.val)) result.add(root);
       
           return result;
        }  
    
    public TreeNode dfs(TreeNode root, HashSet set, List<TreeNode> result){
        if(root== null) return null;
        root.left = dfs(root.left, set, result);
        root.right = dfs(root.right,set,result);
        
        if(set.contains(root.val)){
            if(root.left!=null) result.add(root.left);
            if(root.right!=null) result.add(root.right);
            return null;
        }
        return root;
    }
}
