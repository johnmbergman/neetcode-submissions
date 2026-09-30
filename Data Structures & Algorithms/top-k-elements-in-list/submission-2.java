class Solution {
    public int[] topKFrequent(final int[] nums, final int k) {

        // Get counts
        final Map<Integer, Integer> counts = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            counts.merge(nums[i], 1, Integer::sum);
        }

        // Prepare frequencies
        final Map<Integer, List<Integer>> frequencies = new HashMap<>();
        for (int i = 0; i < nums.length + 1; i++) {
            frequencies.put(i, new ArrayList<>());
        }

        // Get frequencies by flipping counts
        for (int num : counts.keySet()) {
            final int count = counts.get(num);
            frequencies.get(count).add(num);
        }
        System.out.println(frequencies);

        // Return top k from frequencies
        final int[] result = new int[k];
        int found = 0;
        for (int count = nums.length; count > 0; count--) {
            for (int num : frequencies.get(count)) {
                result[found] = num;
                found++;
                if (found >= k) return result;
            }
        }

        return result;
    }
}
