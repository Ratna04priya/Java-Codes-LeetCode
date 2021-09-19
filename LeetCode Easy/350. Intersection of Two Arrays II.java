//350. Intersection of Two Arrays II
//By Ratna Priya

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int pointer1 = 0;
        int pointer2 = 0;
        
        List<Integer> ret = new ArrayList<Integer>();
        while(pointer1<nums1.length&&pointer2<nums2.length){
            if(nums1[pointer1]==nums2[pointer2]){
                ret.add(nums1[pointer1]);
                pointer1++;
                pointer2++;
            } else if(nums1[pointer1]>nums2[pointer2]){
                pointer2++;
            } else pointer1++;
        }
        return toArray(ret);
    }
                                               
    int[] toArray(List<Integer> list){
        int[] ret = new int[list.size()];
        for(int i=0;i<list.size();i++){
            ret[i] = list.get(i);
        }
        return ret;
    }
    
}
