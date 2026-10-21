class MedianFinder {
    final Queue<Integer> minHeap = new PriorityQueue<>(Collections.reverseOrder());
    final Queue<Integer> maxHeap = new PriorityQueue<>();
    
    public void addNum(final int num) {
        maxHeap.add(num);
        minHeap.add(maxHeap.poll());

        if (minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.poll());
        }

    }
    
    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            final int a = maxHeap.peek();
            final int b = minHeap.peek();
            return ((double) a + b) / 2.0;
        } else {
            return maxHeap.peek();
        }
    }
}
