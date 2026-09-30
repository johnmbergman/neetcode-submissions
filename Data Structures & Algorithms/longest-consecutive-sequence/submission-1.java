class Solution {
    public int longestConsecutive(int[] nums) {
        final Set<Integer> cache = new HashSet<>();
        for (int num : nums) cache.add(num);

        // Find each start of sequence
        int longestConsecutiveSequence = 0;
        for (int num : nums) {
            if (cache.contains(num-1)) continue;

            // Found a sequence, determine length
            int sequenceLength = 1;
            while (cache.contains(num+sequenceLength)) sequenceLength++;
            longestConsecutiveSequence = Math.max(sequenceLength, longestConsecutiveSequence);
        }

        return longestConsecutiveSequence;
    }
}
