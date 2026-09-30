class Solution {
    private static final char EMPTY_CELL = '.';
    private static final int BOARD_LENGTH = 9;
    private static final int BOX_SIZE = BOARD_LENGTH / 3;

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < BOARD_LENGTH; i++) {
            if (!isValidRow(i, board)) return false;
            if (!isValidColumn(i, board)) return false;
            if (!isValidBox(i, board)) return false;
        }
        return true;
    }

    private boolean isValidRow(final int row, final char[][] board) {
        final Set<Integer> seen = new HashSet<>();
        for (int i = 0; i < BOARD_LENGTH; i++) {
            final char ch = board[row][i];
            if (ch == EMPTY_CELL) continue;
            final int val = ch - '0';
            if (!seen.add(val)) return false;
        }
        return true;
    }

    private boolean isValidColumn(final int col, final char[][] board) {
        final Set<Integer> seen = new HashSet<>();
        for (int i = 0; i < BOARD_LENGTH; i++) {
            final char ch = board[i][col];
            if (ch == EMPTY_CELL) continue;
            final int val = ch - '0';
            if (!seen.add(val)) return false;
        }
        return true;
    }

    private boolean isValidBox(final int box, final char[][] board) {
        final Set<Integer> seen = new HashSet<>();
        final int startRow = (box / BOX_SIZE) * BOX_SIZE;
        final int startCol = (box % 3) * BOX_SIZE;
        for (int row = startRow; row < startRow + BOX_SIZE; row++) {
            for (int col = startCol; col < startCol + BOX_SIZE; col++) {
                final char ch = board[row][col];
                if (ch == EMPTY_CELL) continue;
                final int val = ch - '0';
                if (!seen.add(val)) return false;
            }
        }
        return true;
    }
}
