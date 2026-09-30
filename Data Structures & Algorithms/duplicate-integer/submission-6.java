class Solution {
    public boolean hasDuplicate(int[] nums) {
        final Set<Integer> distinct = new HashSet<>();
        for (int num : nums) {
            if (!distinct.add(num)) {
                return true;
            }
        }
        return false;
    }
}