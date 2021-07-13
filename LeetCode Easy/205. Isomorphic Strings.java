//205. Isomorphic Strings
//By Ratna Priya

class Solution {
    public boolean isIsomorphic(String s, String t) {
	// Creating a hasmap
        HashMap<Character,Character> map = new HashMap<>();
		
		//If length not equal return false
        if(s.length()!=t.length())
            return false;
        
		//Iterate through each character
        for(int i=0;i<s.length();i++)
        {
            if(map.containsKey(s.charAt(i)))   // Contains the character
            {
                if(map.get(s.charAt(i))!=t.charAt(i)) // And, value not equal to the previous mapped 
                    return false;                                        //return false
            }
            else if(map.containsValue(t.charAt(i))) // It any key has same value
                    return false;                // Then also return false
            else
                map.put(s.charAt(i),t.charAt(i)); // Else put the character pairin the map
        }  
        return true;
    }
}
