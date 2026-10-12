class Solution {
    public boolean hasDuplicate(final int[] nums) {
        final Set<Integer> seen = new HashSet<>();
        for (final int num : nums) {
            if (!seen.add(num)) return true;
        }
        return false;
    }
}