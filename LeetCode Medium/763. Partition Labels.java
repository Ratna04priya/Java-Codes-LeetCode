// 763. Partition Labels - https://leetcode.com/problems/partition-labels/
// By Ratna Priya

class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> parlen = new ArrayList<>();
        int[] lastind = new int[26];
        for(int i =0; i<s.length(); i++){
            lastind[s.charAt(i)-'a'] = i;
        }
        int i =0;
        while(i<s.length()){
            int end = lastind[s.charAt(i)-'a'];
            int j=i;
            while(j!=end){
                end = Math.max(end, lastind[s.charAt(j)-'a']);
                j++;
            }
            parlen.add(j-i+1);
            i = j+1;
        }
        return parlen;
    }
}
