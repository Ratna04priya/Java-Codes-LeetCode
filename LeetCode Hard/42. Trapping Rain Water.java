//42. Trapping Rain Water
// By Ratna Priya

class Solution {
	public int trap(int[] height) {
		if(height.length==0){
			return 0;
		}
		int[] maxL = new int[height.length];
		int[] maxR= new int[height.length];
    
		maxL[0]=height[0];
		for(int i=1; i<height.length; i++){
			maxL[i]=Math.max(maxL[i-1], height[i]);
		}
    
		maxR[height.length-1]=height[height.length-1];
		for(int i=height.length-2; i>=0; i--){
			maxR[i]=Math.max(maxR[i+1], height[i]);
		}
    
		int[] water= new int[height.length];
		for(int i=0;i<height.length;i++){
			water[i]=Math.min(maxL[i],maxR[i])-height[i];
		}
		int sum=0;
		for(int i=0;i<height.length;i++){
			sum=sum+water[i];
		}
		return sum;
	}
}
