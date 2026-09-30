class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        final int[] leftMax = new int[nums.length];
        final int[] rightMax = new int[nums.length];

        leftMax[0] = nums[0];
        rightMax[nums.length-1] = nums[nums.length-1];

        for (int i = 1; i < nums.length; i++) {
            if (i % k == 0) {
                leftMax[i] = nums[i];
            } else {
                leftMax[i] = Math.max(leftMax[i-1], nums[i]);
            }

            final int j = nums.length - 1 - i;
            if (j % k == 0) {
                rightMax[j] = nums[j];
            } else {
                rightMax[j] = Math.max(rightMax[j+1], nums[j]);
            }
        }

        final int[] output = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length - k + 1; i++) {
            output[i] = Math.max(leftMax[i + k - 1], rightMax[i]);
        }

        return output;
    }
}
