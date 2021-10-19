//496. Next Greater Element I
//By Ratna Priya

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
	int m= nums1.length, n= nums2.length;
	int[] stack= new int[n];
	Map<Integer,Integer> next= new HashMap<>();
	for(int i=0, j=-1; i<n; i++){
		while(j!=-1 && nums2[i]>stack[j])
			next.put(stack[j--], nums2[i]);
		stack[++j]= nums2[i];            
	}
	int[] ans= new int[m];
	for(int i=0; i<m; i++)
		ans[i]= next.getOrDefault(nums1[i], -1);
	return ans;
}
}
