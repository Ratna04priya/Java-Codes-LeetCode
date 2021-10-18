//993. Cousins in Binary Tree
//By Ratna Priya

class Solution {
     boolean res = false;
     int levelx, levely;
    TreeNode parentx, parenty;
   // HashMap<Integer, Integer> map = new HashMap<>();
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        cousins(root, null, x, y,0);
        if(levelx == levely && parentx != parenty){ 
        res = true;}
        return res;
        
    }
    public void cousins(TreeNode root, TreeNode parent, int x, int y, int level){
        if(root == null) return;
        
       // map.add(root, level);
        if(root.val == x){
            parentx = parent;
            levelx = level;
        }
        else if(root.val == y){
            parenty = parent;
            levely = level;
        }
        else{
            cousins(root.left, root, x, y, level+1);
            cousins(root.right, root, x, y, level+1);
         }
        }
        
}
