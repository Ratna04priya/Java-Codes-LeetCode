// 1046. Last Stone Weight
//https://leetcode.com/problems/last-stone-weight/
/*Input: [2,7,4,1,8,1]
Output: 1
Explanation: 
We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of last stone.*/

class Solution {
    public int lastStoneWeight(int[] stones) {
        
    PriorityQueue<Integer> maxheap = new PriorityQueue<>();
        for(int stone : stones){
            maxheap.add(-stone);
        }
        while(maxheap.size() >1){
            int stoneOne = -maxheap.remove();
            int stoneTwo = -maxheap.remove();
            if(stoneOne != stoneTwo){
                maxheap.add(-(stoneOne - stoneTwo));
            }
        }
        return maxheap.isEmpty()?0:-maxheap.remove();
    }
}