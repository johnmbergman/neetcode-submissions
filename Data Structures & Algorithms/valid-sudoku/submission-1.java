class Solution {

    private static final Set<Character> VALID_CHARS = new HashSet<>(
        Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9'));

    public boolean isValidSudoku(char[][] board) {

        // Validate rows
        for (int row = 0; row < board.length; row++) {
            final Set<Character> distinct = new HashSet<>();
            for (int col = 0; col < board.length; col++) {
                final char val = board[row][col];
                if (val == '.') continue;
                if (!VALID_CHARS.contains(val)) return false;
                if (distinct.add(val) == false) return false;
            }
        }

        // Validate cols
        for (int col = 0; col < board.length; col++) {
            final Set<Character> distinct = new HashSet<>();
            for (int row = 0; row < board.length; row++) {
                final char val = board[row][col];
                if (val == '.') continue;
                if (!VALID_CHARS.contains(val)) return false;
                if (distinct.add(val) == false) return false;
            }
        }

        // Validate grids
        for (int square = 0; square < 9; square++) {
            final Set<Character> distinct = new HashSet<>();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int row = (square / 3) * 3 + i;
                    int col = (square % 3) * 3 + j;
                    final char val = board[row][col];
                    if (val == '.') continue;
                    if (!VALID_CHARS.contains(val)) return false;
                    if (distinct.add(val) == false) return false;
                }
            }
        }

        for (int i = 0; i < board.length; i += 3) {
            for (int j = 0; j < board.length; j += 3) {
                final Set<Character> distinct = new HashSet<>();
                for (int row = i; row < i + 3; row++) {
                    for (int col = i; col < i + 3; col++) {
                        final char val = board[row][col];
                        if (val == '.') continue;
                        if (!VALID_CHARS.contains(val)) return false;
                        if (distinct.add(val) == false) return false;
                    }
                }
            }
        }

        return true;
    }
}
