class Solution {
    
    private static final int WATER = -1;
    private static final int TREASURE = 0;
    private static final int LAND = Integer.MAX_VALUE;
    private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public void islandsAndTreasure(int[][] grid) {

        final Queue<Coordinate> q = new LinkedList<Coordinate>();

        // Insert all treasure chests in queue
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == TREASURE) q.add(new Coordinate(row, col));
            }
        }

        // go through queue and expand outwards (BFS)
        while (!q.isEmpty()) {
            final Coordinate coordinate = q.poll();
            final int row = coordinate.row;
            final int col = coordinate.col;
            for (int[] dir : DIRECTIONS) {
                final int nrow = row + dir[0];
                final int ncol = col + dir[1];
                if (!isInBounds(grid, nrow, ncol)) continue;
                if (grid[nrow][ncol] != LAND) continue;

                grid[nrow][ncol] = grid[row][col] + 1;
                q.add(new Coordinate(nrow, ncol));
            }
        }
    }

    private boolean isInBounds(final int[][] grid, final int row, final int col) {
        if (row < 0) return false;
        if (col < 0) return false;
        if (row >= grid.length) return false;
        if (col >= grid[row].length) return false;
        return true;
    }

    private static class Coordinate {
        private final int row;
        private final int col;

        public Coordinate(final int row, final int col) {
            this.row = row;
            this.col = col;
        }
    }
}
