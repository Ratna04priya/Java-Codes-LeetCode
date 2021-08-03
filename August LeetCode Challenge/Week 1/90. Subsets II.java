//90. Subsets II
//By Ratna Priya

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums, 0, new ArrayList<>(), false, result);

        return result;
    }
    
    private void helper(int[] nums, int index, List<Integer> soFar, boolean include, List<List<Integer>> result)
    {
        if (index == nums.length)
        {
            result.add(new ArrayList<>(soFar));
        }
        else
        {
            if (index > 0 && nums[index] == nums[index-1] && !include)
            {
                helper(nums, index+1, soFar, false, result);
                return;
            }
                       
            int val = nums[index];
            helper(nums, index+1, soFar, false, result);
            soFar.add(val);
            helper(nums, index+1, soFar, true, result);
            soFar.remove(soFar.size()-1);
        }
    }
}
