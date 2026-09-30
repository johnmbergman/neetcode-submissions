class Solution {
    public int[] twoSum(int[] nums, int target) {
        final Map<Integer, Integer> complements = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            final int num = nums[i];
            final int complement = target - num;
            if (complements.containsKey(complement)) {
                return new int[] { complements.get(complement), i };
            }
            complements.put(num, i);
        }
        throw new RuntimeException("No solution");
    }
}
