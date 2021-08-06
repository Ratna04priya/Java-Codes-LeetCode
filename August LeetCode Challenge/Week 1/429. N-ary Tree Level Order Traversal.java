// 429. N-ary Tree Level Order Traversal
// By Ratna Priya

class Solution {
	
    public static List<List<Integer>> levelOrder(Node root) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		fillMap(map, 0, root);
		List<List<Integer>> res = new ArrayList<>();
		for(List<Integer> list : map.values())
			res.add(list);
		return res;
        
    }
    
    public static void fillMap(Map<Integer, List<Integer>> map, int level, Node node) {
    	
    	if(node == null)
    		return;
    	
    	 List<Integer> l = map.containsKey(level) ? 
    		 map.get(level) : new ArrayList<>();
    	 l.add(node.val);
    	 map.put(level, l);
    	 
    	 if(node.children == null)
    		 return;
    	 
    	 for(Node kid : node.children)
    		 fillMap(map, level+1, kid);
    		 
    	 
    	 
    	 
    }
}
