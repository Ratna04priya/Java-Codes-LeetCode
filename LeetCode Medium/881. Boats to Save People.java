//881. Boats to Save People - https://leetcode.com/problems/boats-to-save-people/
// By Ratna Priya

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int count =0;
        int i =0;
        int j = people.length -1;
        while(i<=j){
            if(people[i]+people[j] <=limit){
                i++;
                j--;
            }
            else j--;
            count++;
        }
        return count;
    }
}
