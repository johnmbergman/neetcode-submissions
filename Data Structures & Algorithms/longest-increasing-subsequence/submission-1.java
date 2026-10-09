class Solution {
    public int lengthOfLIS(final int[] nums) {
        final int[] memo = new int[nums.length];
        int longest = 1;
        Arrays.fill(memo, 1);

        // Nav from right to left, using our memory to determine
        // if this makes a longest subsequence
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = i + 1; j < nums.length; j++) {

                // It must be decreasing
                if (nums[i] < nums[j]) {
                    memo[i] = Math.max(memo[i], 1 + memo[j]);
                }
                longest = Math.max(longest, memo[i]);
            }
        }
        return longest;
    }
}
