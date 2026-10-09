class Solution {
    public int rob(final int[] nums) {
        final int maxRob = Math.max(
            rob(nums, 0, nums.length - 1),
            rob(nums, 1, nums.length)
        );

        return Math.max(nums[0], maxRob);
    }

    private int rob(final int[] nums, final int startIndex, final int lastIndex) {
        int left = 0;
        int right = 0;
        for (int i = startIndex; i < lastIndex; i++) {
            final int tmp = Math.max(left + nums[i], right);
            left = right;
            right = tmp;
        }
        return right;
    }
}
