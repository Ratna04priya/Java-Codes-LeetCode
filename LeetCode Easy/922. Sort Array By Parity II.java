// 922. Sort Array By Parity II
//By Ratna Priya

class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        
        
        for(int i=0;i<nums.length;i++){
            
            if(i%2==0){
                if(nums[i]%2==0)continue;
                
                for(int j = i+1;j<nums.length;j++){
                    if(nums[j]%2==0){
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                        break;
                    }
                }
            }
            
            else{
                if(nums[i]%2!=0)continue;
                
                for(int j = i+1;j<nums.length;j++){
                    if(nums[j]%2!=0){
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                        break;
                    }
                }
            }
            
        }
        
        return nums;
    }
    
}
