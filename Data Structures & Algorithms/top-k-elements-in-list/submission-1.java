class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // [13, 25, 25, 31, 31, 31] (nums)
        // { 13: 1, 25: 2, 31: 3 }  (counts)
        final Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            counts.merge(num, 1, Integer::sum);
        }

        // { 1: 13, 2: 25, 3: 31 }  (freq)
        final Map<Integer, List<Integer>> freq = new HashMap<>();
        for (int count : counts.values()) {
            freq.put(count, new ArrayList<>());
        }
        for (int num : counts.keySet()) {
            final int count = counts.get(num);
            freq.get(count).add(num);
        }

        // iterate from nums.length to 0
        // populate result array
        final int[] result = new int[k];
        int resultIndex = 0;
        for (int i = nums.length; i >= 0; i--) {
            if (freq.containsKey(i)) {
                // Grab values from the list until we'e reached k
                // or exhausted the list
                for (int num : freq.get(i)) {
                    result[resultIndex] = num;
                    resultIndex++;
                    if (resultIndex == k) return result;
                }
            }
        }
        return result;
    }
}
