class Solution {
    public int longestConsecutive(int[] nums) {

        // A sequence starts whenenver n-1 does not exist
        // This means we can create a hash set to make the
        // n-1 lookup O(1).
        final Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            seen.add(num);
        }

        // Get the length of each sequence
        int longest = 0;
        for (int num : nums) {
            // Skip if not the start of a sequence
            if (seen.contains(num - 1)) continue;

            // Get the length of the sequence
            int length = 1;
            while (seen.contains(num + length)) length++;

            // Keep the longest
            longest = Math.max(length, longest);
        }

        return longest;
    }
}
