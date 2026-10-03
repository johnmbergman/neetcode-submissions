class Solution {
    public boolean exist(final char[][] board, final String word) {
        final boolean[][] visited = new boolean[board.length][board[0].length];

        // Iterate through each cell on the board
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (search(word, board, visited, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    private boolean search(
        final String word,
        final char[][] board,
        final boolean[][] visited,
        final int i,
        final int x,
        final int y
    ) {
        // Base case - last character of word
        if (i == word.length()) {
            // The word has been found
            return true;
        }

        final boolean isInBounds = x >= 0
                                && x < board.length
                                && y >= 0
                                && y < board[0].length;

        // Otherwise check the character
        if (isInBounds && !visited[x][y] && word.charAt(i) == board[x][y]) {
            // It's a match. Mark as visited
            visited[x][y] = true;
            
            // Try to travel in each direction
            for (final int[] delta : DIRECTIONS) {
                final int nextX = x + delta[0];
                final int nextY = y + delta[1];
                if (search(word, board, visited, i+1, nextX, nextY)) {
                    return true;
                }
            }
            visited[x][y] = false;
        }

        // Not the last word and character doesn't match - dead end
        return false;
    }
}
