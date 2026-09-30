class Solution {

    // Two solutions:
    // 1 (naive): O(n^2)
    // for (int i = 0; i < nums.length; i++) {
    //   for (int j = i + 1; j < nums.length; j++) {
    //     if (nums[i] == nums[j]) return true;
    //   }
    // }
    //
    // 2 (optimized but cost more memory): O(n)
    public boolean hasDuplicate(final int[] nums) {
        final Set<Integer> visited = new HashSet<>();
        for (int num : nums) {
            if (!visited.add(num)) return true;
        }
        return false;
    }
}