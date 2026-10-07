class WordDictionary {
    private static final String LOWERCASE_ENGLISH_LETTERS = "abcdefghijklmnopqrstuvwxyz";

    private final Node root = new Node();

    public void addWord(final String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            final char ch = word.charAt(i);
            curr = curr.ensureNext(ch);
        }
        curr.endOfWord = true;
    }

    public boolean search(final String word) {
        return dfs(word, 0, root);

        /*
        Node curr = root;
        for (final char ch : word.toCharArray()) {
            if (ch == '.') {
                throw new RuntimeException("Not implemented");
            } else {
                if (!curr.hasNext(ch)) return false;
                curr = curr.get(ch);
            }
        }
        return curr.endOfWord;
        */
    }

    private boolean dfs(final String word, final int i, final Node curr) {
        // Base case - we have reached the end of the word or trie
        if (i >= word.length()) {
            return curr.endOfWord;
        }

        // Determine the next words we need to check
        final char ch = word.charAt(i);
        final char[] nextChars;
        if (ch == '.') {
            nextChars = LOWERCASE_ENGLISH_LETTERS.toCharArray();
        } else {
            nextChars = new char[] { ch };
        }

        for (final char nextChar : nextChars) {
            if (curr.hasNext(nextChar)) {
                if (dfs(word, i+1, curr.get(nextChar))) return true;
            }
        }

        return false;
    }

    private static class Node {
        final Node[] children = new Node[26];
        boolean endOfWord = false;

        private Node get(final char ch) {
            return children[indexOf(ch)];
        }

        private boolean hasNext(final char ch) {
            return children[indexOf(ch)] != null;
        }

        private Node ensureNext(final char ch) {
            if (!hasNext(ch)) {
                children[indexOf(ch)] = new Node();                
            }
            return children[indexOf(ch)];
        }

        private int indexOf(final char ch) {
            return ch - 'a';
        }
    }
}
