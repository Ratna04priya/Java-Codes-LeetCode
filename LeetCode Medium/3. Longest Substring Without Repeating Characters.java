// Longest Substring Without Repeating Characters
//By Ratna Priya

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int max = 0;
        int startind = 0;
        int i = 0;
        while(i < s.length()){
            char current = s.charAt(i);
            if(!set.contains(current))
            {
                set.add(current);
                System.out.println(set);
                i++;
                max = Math.max(max, set.size());
            }
            else{
                set.remove(s.charAt(startind));
                System.out.println(startind);
                startind++;
                System.out.println(startind);
                //set.add(current);
                }
            
        }
        return max;       
    }
}
