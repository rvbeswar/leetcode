class Solution {
    Map<Map.Entry<Integer,Integer>,Integer> map;
    public int findTargetSumWays(int[] nums, int target) {
        int currSum = 0;
        int index = nums.length-1;
        map = new HashMap<>();
        return targetSum(nums, target, index,currSum);
    }
    private int targetSum(int[] nums, int target,int index,int currSum)
    {
        Map.Entry<Integer,Integer> entry = Map.entry(index,currSum);
        if(map.containsKey(entry))
        {
            return map.get(entry);
        }
        else if(index<0 && currSum==target)
        {
            return 1;
        }
        else if(index<0)
        {
           return 0;
        }
    
        int pos = targetSum(nums, target, index-1,currSum+nums[index]);
        int neg = targetSum(nums, target, index-1,currSum-nums[index]);
        
        map.put(entry,pos+neg);
        return pos+neg;
    }
}