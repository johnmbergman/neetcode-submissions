class Solution {

    public List<String> findWords(final char[][] board, final String[] words) {

        // Setup the prefix tree and populate with known words
        final Node root = new Node(); // Sentinel root
        for (final String word : words) {
            addWord(root, word);
        }

        // Search word grid for known words
        final Set<String> result = new HashSet<>();
        final boolean[][] visited = new boolean[board.length][board[0].length];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                findWords(board, root, row, col, result, visited);
            }
        }
        return new ArrayList<>(result);
    }

    private void findWords(
        final char[][] board,
        final Node curr,
        final int row,
        final int col,
        final Set<String> result,
        final boolean[][] visited
    ) {
        // Check if end of word
        if (curr == null) return;
        if (curr.isEndOfWord()) {
            result.add(curr.word);
        }

        if (isOutOfBounds(board, row, col)) return;
        if (visited[row][col]) return;

        // Continue search
        final char ch = board[row][col];
        final Node next = curr.get(ch);
        visited[row][col] = true;
        findWords(board, next, row+1, col, result, visited);
        findWords(board, next, row-1, col, result, visited);
        findWords(board, next, row, col+1, result, visited);
        findWords(board, next, row, col-1, result, visited);
        visited[row][col] = false;
    }

    // Utility Method: Adds the word to the trie (via sentinel root)
    private void addWord(final Node root, final String word) {
        Node curr = root;
        for (final char ch : word.toCharArray()) {
            curr = curr.getOrCreate(ch);
        }
        curr.word = word;
    }

    private boolean isOutOfBounds(final char[][] board, final int row, final int col) {
        if (row < 0 || col < 0) return true;
        if (row >= board.length) return true;
        if (col >= board[0].length) return true;
        return false;
    }

    /**
     * Prefix tree Node.
     * Stores the next Node (indexed by char - 'a'), if one exists.
     * Stores the word if this Node is the last character of a word.
     *    (otherwise, word will be null).
     */
    private static class Node {
        private final Node[] next = new Node[26];
        private String word = null;

        private Node get(final char ch) {
            return next[indexOf(ch)];
        }

        private Node getOrCreate(final char ch) {
            final int i = indexOf(ch);
            if (next[i] == null) {
                next[i] = new Node();
            }
            return next[i];
        }

        private boolean isEndOfWord() {
            return word != null;
        }

        private static int indexOf(final char ch) {
            return ch - 'a';
        }
    }
}
