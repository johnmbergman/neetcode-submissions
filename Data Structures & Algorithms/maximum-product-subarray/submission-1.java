class Solution {
    public int maxProduct(final int[] nums) {
        int max = nums[0];
        int prefix = 0;
        int suffix = 0;

        for (int i = 0; i < nums.length; i++) {
            prefix = nums[i] * (prefix == 0 ? 1 : prefix);
            suffix = nums[nums.length - i - 1] * (suffix == 0 ? 1 : suffix);
            max = Math.max(max, Math.max(prefix, suffix));
        }

        return max;
    }
}
