class Solution {
    public int search(final int[] nums, final int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            final int m = l + ((r - l) / 2);
            if (nums[m] == target) {
                return m;
            } else if (nums[m] > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return -1;
    }
}
