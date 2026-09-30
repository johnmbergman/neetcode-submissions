class Solution {
    public int search(final int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            final int width = right - left;
            final int middle = left + (width / 2);
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return -1;
    }
}
