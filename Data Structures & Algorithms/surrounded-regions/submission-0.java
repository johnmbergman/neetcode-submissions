class Solution {
    private static final int[][] DIRECTIONS = new int[][] {
        {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };


    public void solve(char[][] board) {
        final int rows = board.length;
        final int cols = board[0].length;

        final Queue<Cell> q = new LinkedList<>();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                final boolean isTopOrBottomRow = row == 0 || row == rows - 1;
                final boolean isTopOrBottomCol = col == 0 || col == cols - 1;
                if (isTopOrBottomRow || isTopOrBottomCol && board[row][col] == 'O') {
                    q.offer(new Cell(row, col));
                }
            }
        }

        while (!q.isEmpty()) {
            final Cell cell = q.poll();
            if (!cell.isInBounds(board)) continue;
            if (board[cell.row][cell.col] == 'O') {
                board[cell.row][cell.col] = 'T';
                cell.getNeighbors().forEach(q::offer);
            }
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col] == 'O') {
                    board[row][col] = 'X';
                } else if (board[row][col] == 'T') {
                    board[row][col] = 'O';
                }
            }
        }

    }

    private static class Cell {
        private final int row;
        private final int col;

        private Cell(final int row, final int col) {
            this.row = row;
            this.col = col;
        }

        private Collection<Cell> getNeighbors() {
            final Collection<Cell> result = new ArrayList<>();
            for (int[] direction : DIRECTIONS) {
                final int newRow = row + direction[0];
                final int newCol = col + direction[1];
                result.add(new Cell(newRow, newCol));
            }
            return result;
        }

        private boolean isInBounds(final char[][] board) {
            if (row < 0) return false;
            if (col < 0) return false;
            if (row >= board.length) return false;
            if (col >= board[0].length) return false;
            return true;
        }
    }
}
