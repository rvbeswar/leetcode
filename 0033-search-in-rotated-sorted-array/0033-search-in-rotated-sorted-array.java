class Solution {
    public int search(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // left sorted array
            //if mid > than Low, everything left of mid is sorted
            //if mid < than Low, everything right of mid is sorted
            else if (nums[low] <= nums[mid]) {
                if (nums[mid] < target || nums[low] > target)
                    low = mid + 1;
                else {
                    high = mid - 1;
                }
            }
            // right sorted array
            else {
                if (nums[mid] > target || nums[high] < target)
                    high = mid - 1;
                else {
                    low = mid + 1;
                }
            }

        }
        return -1;
    }
}