class Solution {
    public int longestConsecutive(int[] nums) {

        // Create and populate a hash set
        final Set<Integer> cache = new HashSet<>();
        for (int num : nums) {
            cache.add(num);
        }

        // Identify each start of sequence and get sequence length
        int longestSize = 0;
        for (int num : nums) {
            final boolean isStartOfSequence = !cache.contains(num-1);
            if (isStartOfSequence) {
                // Get sequence length
                int currentSize = 1;
                while (cache.contains(num + currentSize)) {
                    currentSize++;
                }
                longestSize = Math.max(currentSize, longestSize);
            }
        }

        return longestSize;
    }
}
