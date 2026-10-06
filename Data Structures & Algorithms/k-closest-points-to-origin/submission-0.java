class Solution {

    public int[][] kClosest(final int[][] points, final int k) {
        final Queue<Coordinate> heap = new PriorityQueue<>(
            Comparator.comparingInt(c -> c.x * c.x + c.y * c.y));

        for (int[] point : points) {
            heap.add(new Coordinate(point[0], point[1]));
        }

        final int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            final Coordinate next = heap.poll();
            result[i][0] = next.x;
            result[i][1] = next.y;
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

        public double distanceFrom(final Coordinate other) {
            final int dx = x - other.x;
            final int dy = y - other.y;
            return Math.sqrt(dx * dx + dy * dy);
        }
    }
}
