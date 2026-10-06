class Solution {

    public int[][] kClosest(final int[][] points, final int k) {
        final Queue<Coordinate> maxHeap = new PriorityQueue<>(
            Comparator.comparingInt(Coordinate::distanceSquared).reversed()
        );

        for (final int[] point : points) {
            maxHeap.add(new Coordinate(point[0], point[1]));
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        final int[][] result = new int[k][2];
        int i = 0;
        while (!maxHeap.isEmpty()) {
            final Coordinate point = maxHeap.poll();
            result[i++] = new int[] { point.x, point.y };
        }
        return result;
    }

    private static class Coordinate {
        private int x;
        private int y;

        private static final Coordinate ORIGIN = new Coordinate(0, 0);

        public Coordinate(final int x, final int y) {
            this.x = x;
            this.y = y;
        }

        public int distanceSquared() {
            return x * x + y * y;
        }
    }
}
