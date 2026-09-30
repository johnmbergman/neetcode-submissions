class Solution {
    public int longestConsecutive(int[] nums) {

        // Convert to set
        final Set<Integer> distinct = new HashSet<>();
        for (final int num : nums) {
            distinct.add(num);
        }

        int longest = 0;
        for (final int num : nums) {

            // Check if this is beginning of a sequence
            if (!distinct.contains(num-1)) {
                int len = 0;
                while (distinct.contains(num+len)) len++;
                longest = Math.max(longest, len);
            }
        }
        return longest;
    }
}
