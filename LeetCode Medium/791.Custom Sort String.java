// 791.Custom Sort String
//By Ratna Priya

class Solution {
    public String customSortString(String order, String str) {
     HashMap<Character , Integer> map = new HashMap<>();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(map.containsKey(ch) == false){
                map.put(ch , 1);
            }
            else{
                map.put(ch , map.get(ch) + 1);
            }
        }
        String ans = "";
        
        for(int i=0;i<order.length();i++){
            char ch = order.charAt(i);
            if(map.containsKey(ch) == true){
                for(int j=0;j<map.get(ch);j++)
                    ans += ch;
                map.remove(ch);
            }
        }
        for(Map.Entry<Character , Integer> m:map.entrySet()){
            char key = m.getKey();
            int val = m.getValue();
            for(int i=0;i<val;i++)
                ans += key; 
        }
        return ans;
        
    }
}

