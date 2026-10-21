class Solution {
    public int leastInterval(final char[] tasks, final int n) {

        // Get the count of each character
        final int[] counts = new int[26];
        for (final char task : tasks) {
            counts[task - 'A']++;
        }

        // Build a max heap where each entry is remaining count of a task
        final Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (final int count : counts) {
            if (count > 0) {
                maxHeap.add(count);
            }
        }

        int time = 0;
        final Queue<int[]> q = new LinkedList<>();
        while (!maxHeap.isEmpty() || !q.isEmpty()) {
            time++;

            if (maxHeap.isEmpty()) {
                time = q.peek()[1];
            } else {
                final int count = maxHeap.poll() - 1;
                if (count > 0) {
                    q.add(new int[]{count, time + n});
                }
            }

            if (!q.isEmpty() && q.peek()[1] == time) {
                maxHeap.add(q.poll()[0]);
            }
        }

        return time;
    }
}
