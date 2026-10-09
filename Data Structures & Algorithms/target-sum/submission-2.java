class Solution {
    public int findTargetSumWays(final int[] nums, final int target) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 1);

        for (final int num : nums) {
            final Map<Integer, Integer> nextDp = new HashMap<>();
            for (final int total : dp.keySet()) {
                final int count = dp.get(total);
                nextDp.put(total + num, nextDp.getOrDefault(total + num, 0) + count);
                nextDp.put(total - num, nextDp.getOrDefault(total - num, 0) + count);
            }
            dp = nextDp;
        }
        return dp.getOrDefault(target, 0);
    }
}
