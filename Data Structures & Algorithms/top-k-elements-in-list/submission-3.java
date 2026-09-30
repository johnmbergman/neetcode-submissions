class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (k == 0) return new int[0];

        // Get the count of each number
        final Map<Integer, Integer> counts = new HashMap<>();
        for (final int num : nums) {
            counts.merge(num, 1, Integer::sum);
        }

        // Flip the map to be keyed on the count
        final Map<Integer, List<Integer>> frequencies = new HashMap<>();
        for (int num : counts.keySet()) {
            final int count = counts.get(num);
            frequencies.putIfAbsent(count, new ArrayList<>());
            frequencies.get(count).add(num);
        }

        // Get the top k by looping from nums.length to 0 until we have k results
        int[] result = new int[k];
        int found = 0;
        for (int count = nums.length; count >= 0; count--) {
            System.out.println("Checking count: " + count);
            for (int num : frequencies.getOrDefault(count, new ArrayList<>())) {
                System.out.println(num);
                result[found] = num;
                found++;
                if (found == k) return result;
            }
        }

        return result;
    }
}
