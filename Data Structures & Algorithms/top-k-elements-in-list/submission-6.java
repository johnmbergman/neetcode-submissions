class Solution {
    public int[] topKFrequent(final int[] nums, final int k) {
        // Number: Count
        final Map<Integer, Integer> counts = new HashMap<>();
        for (final int num : nums) {
            counts.merge(num, 1, Integer::sum);
        }

        // Count: List(Number)
        int maxCount = 0;
        final Map<Integer, Set<Integer>> freq = new HashMap<>(); // Count: List<Number>
        for (final int num : nums) {
            final int count = counts.get(num);
            maxCount = Math.max(maxCount, count);
            freq.computeIfAbsent(count, key -> new HashSet<>());
            freq.get(count).add(num);
        }

        final int[] result = new int[k];
        int found = 0;
        for (int i = maxCount; i >= 0; i--) {
            if (!freq.containsKey(i)) continue;
            for (final int num : freq.get(i)) {
                result[found] = num;
                found++;
                if (found == k) return result;
            }
        }

        return result;
    }
}
