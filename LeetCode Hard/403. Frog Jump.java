// 403. Frog Jump - https://leetcode.com/problems/frog-jump/
// Ratna Priya

class Solution {
    public boolean canCross(int[] stones) {
        for(int i = 3; i<stones.length; i++){
            if(stones[i]> stones[i-1]*2){
                return false;
            }
        }
        HashSet<Integer> stonesPositions = new HashSet<>();
        for(int stone : stones){
            stonesPositions.add(stone);
        }
        
        int lastStone = stones[stones.length -1];
        Stack<Integer> positions = new Stack<>();
        Stack<Integer> jumps = new Stack<>();
        positions.add(0);
        jumps.add(0);
        while(!positions.isEmpty()){
            int position = positions.pop();
            int jumpdistance = jumps.pop();
            for(int i = jumpdistance -1; i<= jumpdistance +1; i++){
                if(i<=0){
                    continue;
                }
                int nextposition = position +i;
                if(nextposition == lastStone){
                    return true;
                }
                else if(stonesPositions.contains(nextposition)){
                    positions.add(nextposition);
                    jumps.add(i);
                }
            }
        }
        return false;
        
    }
}
