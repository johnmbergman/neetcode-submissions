class Solution {
    public int longestConsecutive(final int[] nums) {
        final Map<Integer, Integer> counter = new HashMap<>();
        int result = 0;
        for (int num : nums) {
            if (!counter.containsKey(num)) {
                counter.put(num, 1 + counter.getOrDefault(num-1, 0) + counter.getOrDefault(num+1, 0));
                counter.put(num - counter.getOrDefault(num-1, 0), counter.get(num));
                counter.put(num + counter.getOrDefault(num+1, 0), counter.get(num));
                result = Math.max(result, counter.get(num));
            }
        }
        return result;
    }
}
