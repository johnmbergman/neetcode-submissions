class Solution {
    public int[] twoSum(final int[] nums, final int target) {
        final Map<Integer, Integer> complements = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            final int complement = target - nums[i];
            if (complements.containsKey(complement)) {
                return new int[] { complements.get(complement), i };
            }
            complements.put(nums[i], i);
        }
        return null;
    }
}
