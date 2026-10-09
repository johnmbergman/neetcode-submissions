class Solution {
    public int rob(final int[] nums) {
        int left = 0;
        int right = 0;

        for (final int num : nums) {
            int tmp = Math.max(num + left, right);
            left = right;
            right = tmp;
        }
        return right;
    }
}
