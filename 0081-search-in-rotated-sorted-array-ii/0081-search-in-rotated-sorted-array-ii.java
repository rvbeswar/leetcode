class Solution {
    /**
    The only difference is that due to the existence of duplicates,
arr[l] == arr[mid] could be possible, the first half could be out of order
(i.e. not in the ascending order, e.g. {3, 1, 2, 3, 3, 3, 3})
we have to deal this case separately.
In that case, it is guaranteed that arr[high] also equal to arr[mid],
so the condition arr[mid] == arr[l] == arr[r] can be checked before the original logic,
if so then move left and right both towards the middle by 1 and repeat. */
    public boolean search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return true;
            }
            // with duplicates we can have this contdition, just update left & right
            else if((nums[low] == nums[mid]) && (nums[high] == nums[mid]))
            {
                low++;
                high--;
            }
            // left sorted array
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
        return false;
    }
}