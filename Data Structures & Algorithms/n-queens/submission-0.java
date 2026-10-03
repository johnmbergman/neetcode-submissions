class Solution {
    private static final char EMPTY = '.';
    private static final char QUEEN = 'Q';

    public List<List<String>> solveNQueens(final int n) {
        final char[][] board = new char[n][n];
        for (final char[] row : board) {
            Arrays.fill(row, EMPTY);
        }

        final List<List<String>> result = new ArrayList<>();
        search(0, n, board, result, new HashSet<>(), new HashSet<>(), new HashSet<>());
        return result;
    }

    private void search(
        final int row,
        final int n,
        final char[][] board,
        final List<List<String>> result,
        final Set<Integer> column,
        final Set<Integer> positive,
        final Set<Integer> negative
    ) {
        if (row == n) {
            final List<String> copy = new ArrayList<>();
            for (final char[] r : board) {
                copy.add(new String(r));
            }
            result.add(copy);
            return;
        }

        for (int col = 0; col < n; col++) {
            final int pos = row + col;
            final int neg = row - col;
            final boolean attacked = column.contains(col)
                                  || positive.contains(pos)
                                  || negative.contains(neg);
            if (attacked) continue;

            column.add(col);
            positive.add(pos);
            negative.add(neg);
            board[row][col] = QUEEN;
            search(row+1, n, board, result, column, positive, negative);
            column.remove(col);
            positive.remove(pos);
            negative.remove(neg);
            board[row][col] = EMPTY;
        }
    }
}
