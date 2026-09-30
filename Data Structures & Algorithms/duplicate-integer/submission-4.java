class Solution {
    public boolean hasDuplicate(int[] nums) {
        final Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (!seen.add(num)) return true;
        }
        return false;
    }
}
