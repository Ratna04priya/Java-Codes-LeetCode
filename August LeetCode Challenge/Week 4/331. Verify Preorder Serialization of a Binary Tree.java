//331. Verify Preorder Serialization of a Binary Tree
//By Ratna Priya

class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] arr = preorder.split(",");
        int ans = find(arr, 0);
        if(ans == arr.length)
        	return true;
        return false;
    }
    
    public int find(String[] arr, int ptr) {
    	if(ptr == arr.length)
    		return Integer.MIN_VALUE;
    	if(arr[ptr].charAt(0) == '#')
    		return ptr + 1;
    	int fir = find(arr, ptr + 1);
    	if(fir == Integer.MIN_VALUE)
    		return fir;
    	int sec = find(arr, fir);
    	if(sec == Integer.MIN_VALUE)
    		return sec;
    	return sec;
    }
}
