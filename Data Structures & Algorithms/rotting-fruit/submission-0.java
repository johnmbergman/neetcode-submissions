class Solution {

    private static final int NO_FRUIT = 0;
    private static final int FRESH_FRUIT = 1;
    private static final int ROTTEN_FRUIT = 2;

    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int orangesRotting(final int[][] grid) {
        final Queue<int[]> q = new ArrayDeque<>();
        int fresh = 0;
        int time = 0;

        // Count the fresh fruit
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == FRESH_FRUIT) {
                    fresh++;
                } else if (grid[row][col] == ROTTEN_FRUIT) {
                    q.offer(new int[]{row, col});
                }
            }
        }

        while (fresh > 0 && !q.isEmpty()) {
            final int length = q.size();
            for (int i = 0; i < length; i++) {
                final int[] curr = q.poll();
                final int row = curr[0];
                final int col = curr[1];

                for (int[] direction : DIRECTIONS) {
                    final int nextRow = row + direction[0];
                    final int nextCol = col + direction[1];
                    if (nextRow >= 0
                        && nextCol >= 0
                        && nextRow < grid.length
                        && nextCol < grid[0].length
                        && grid[nextRow][nextCol] == FRESH_FRUIT
                    ) {
                        grid[nextRow][nextCol] = ROTTEN_FRUIT;
                        q.offer(new int[]{nextRow, nextCol});
                        fresh--;
                    }
                }
            }
            time++;
        }

        if (fresh == 0) {
            return time;
        } else {
            return -1;
        }
    }
}
