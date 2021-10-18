//437. Path Sum III
//By Ratna Priya

class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null)
            return 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return helper(root, 0, targetSum, map);
    }
    
    public int helper(TreeNode root, int current, int target, Map<Integer, Integer> map) {
        if(root == null)
            return 0;
        
        current += root.val;
        int count = 0;
        
        count += map.getOrDefault(current - target, 0);
        map.put(current, map.getOrDefault(current, 0) + 1);
        
        count += helper(root.left, current, target, map);
        count += helper(root.right, current, target, map);
        
        map.put(current, map.get(current) - 1);
        return count;
    }
}
