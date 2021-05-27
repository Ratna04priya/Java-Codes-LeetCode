//767. Reorganize String - https://leetcode.com/problems/reorganize-string/
// By Ratna Priya

class Solution {
    public String reorganizeString(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }
        PriorityQueue<Character> maxheap = new PriorityQueue<>((a,b) -> map.get(b)-map.get(a));
        maxheap.addAll(map.keySet());
        
        StringBuilder result = new StringBuilder();
        while(maxheap.size()>1){
            char current = maxheap.remove();
            char next = maxheap.remove();
            result.append(current);
            result.append(next);
            map.put(current, map.get(current)-1);
            map.put(next, map.get(next)-1);
            
            if(map.get(current)>0){
                maxheap.add(current);
            }
            if(map.get(next)>0){
                maxheap.add(next);
            }
        }
        if(!maxheap.isEmpty()){
            char c = maxheap.remove();
            if(map.get(c)>1)
                return "";
            result.append(c);
        }
        return result.toString();
    }
}
