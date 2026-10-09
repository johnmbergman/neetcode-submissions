class Solution {
    public int maxSubArray(final int[] nums) {
        int maxSum = nums[0];
        int curSum = 0;
        for (final int num : nums) {
            if (curSum < 0) {
                curSum = 0;
            }
            curSum += num;
            maxSum = Math.max(maxSum, curSum);
        }
        return maxSum;
    }
}
