class KthLargest {
    private final Queue<Integer> minHeap = new PriorityQueue<>();
    private final int k;

    public KthLargest(final int k, final int[] nums) {
        this.k = k;
        for (final int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
    }
    
    public int add(int val) {
        minHeap.add(val);
        if (minHeap.size() > k) {
            minHeap.poll();
        }
        return minHeap.peek();
    }
}
