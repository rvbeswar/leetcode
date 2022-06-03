class Solution {
    int count=0;
    public int findTargetSumWays(int[] nums, int target) {
        int currSum = 0;
        int index = nums.length-1;
        return targetSum(nums, target, index,currSum);
    }
    private int targetSum(int[] nums, int target,int index,int currSum)
    {
        if(index<0 && currSum==target)
        {
            return count++;
        }
        else if(index<0)
        {
           return count;
        }
        targetSum(nums, target, index-1,currSum+nums[index]);
        targetSum(nums, target, index-1,currSum-nums[index]);
        return count;
    }
}