class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // Get the count of each integer
        final Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            counts.merge(num, 1, Integer::sum);
        }

        // Assign the frequency to an array
        final List<Integer>[] frequencies = new List[nums.length + 1];
        for (int key : counts.keySet()) {
            int val = counts.get(key);
            if (frequencies[val] == null) frequencies[val] = new ArrayList<>();
            frequencies[val].add(key);
        }

        final int[] res = new int[k];
        int index = 0;
        for (int i = frequencies.length - 1; i > 0 && index < k; i--) {
            if (frequencies[i] == null) continue;
            for (int n : frequencies[i]) {
                res[index] = n;
                index++;
                if (index == k) return res;
            }
        }
        return res;
    }
}
