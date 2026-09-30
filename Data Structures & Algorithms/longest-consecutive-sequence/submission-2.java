class Solution {
    public int longestConsecutive(int[] nums) {

        // Cache the numbers in a set for constant-time access
        final Set<Integer> cache = new HashSet<>();
        for (int num : nums) {
            cache.add(num);
        }

        // Get each beginning of a sequence (cache doesn't contain n-1)
        int longest = 0;
        for (int num : nums) {
            if (cache.contains(num-1)) continue;
            int length = 1;
            while (cache.contains(num + length)) {
                length++;
            }
            longest = Math.max(longest, length);
        }
        return longest;
    }
}
