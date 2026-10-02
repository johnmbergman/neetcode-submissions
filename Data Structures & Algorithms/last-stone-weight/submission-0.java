class Solution {

    public int lastStoneWeight(final int[] stones) {
        // Store count of weights for index of array
        // e.g., weight 100 goes in counts[100], etc..
        int maxWeight = 0;
        for (int stone : stones) {
            maxWeight = Math.max(maxWeight, stone);
        }

        final int[] counts = new int[maxWeight + 1];

        // Pre-process stone weights to get count of each
        for (int i = 0; i < stones.length; i++) {
            final int weight = stones[i];
            counts[weight]++;
        }

        // Loop from max to min weight. Combine stones until 1 or 0 remain
        // [6]=1, [4]=1, [3]=1, [2]=2
        int first = maxWeight;
        int second = maxWeight;

        while (first > 0) {
            // If it's even then they effectively cancel out
            if (counts[first] % 2 == 0) {
                first--;
                continue;
            }

            // Find the next stone
            int j = Math.min(first - 1, second);
            while (j > 0 && counts[j] == 0) {
                j--;
            }
            // Check if first is the last stone
            if (j == 0) {
                return first;
            }

            second = j;
            counts[first]--;
            counts[second]--;
            counts[first-second]++;
            first = Math.max(first - second, second);
        }

        return first;
    }
}
