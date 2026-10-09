class Solution {

    private static final int NO_FRUIT = 0;
    private static final int FRESH_FRUIT = 1;
    private static final int ROTTEN_FRUIT = 2;
    private static final int VISITED_FRUIT = 3;

    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int orangesRotting(final int[][] grid) {
        int fresh = 0;
        int time = 0;

        // Count the fresh fruit
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == FRESH_FRUIT) {
                    fresh++;
                }
            }
        }

        while (fresh > 0) {
            boolean found = false;

            // Loop over each cell
            for (int row = 0; row < grid.length; row++) {
                for (int col = 0; col < grid[0].length; col++) {

                    if (grid[row][col] == ROTTEN_FRUIT) {
                        for (int[] direction : DIRECTIONS) {
                            final int nextRow = row + direction[0];
                            final int nextCol = col + direction[1];
                            if (nextRow >= 0
                                && nextCol >= 0
                                && nextRow < grid.length
                                && nextCol < grid[0].length
                                && grid[nextRow][nextCol] == FRESH_FRUIT
                            ) {
                                grid[nextRow][nextCol] = VISITED_FRUIT;
                                fresh--;
                                found = true;
                            }
                        }
                    }
                }
            }

            if (!found) return -1;

            for (int row = 0; row < grid.length; row++) {
                for (int col = 0; col < grid[0].length; col++) {
                    if (grid[row][col] == VISITED_FRUIT) {
                        grid[row][col] = ROTTEN_FRUIT;
                    }
                }
            }

            time++;
        }

        return time;
    }
}
