class Solution {
    public int findKthLargest(final int[] nums, final int k) {
        final Queue<Integer> heap = new PriorityQueue<>();
        for (final int num : nums) {
            heap.add(num);
            if (heap.size() > k) heap.poll();
        }
        return heap.peek();
    }
}
