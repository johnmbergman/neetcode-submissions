class WordDictionary {

    private static final char WILDCARD = '.';

    private final TrieNode root = new TrieNode();

    public void addWord(final String word) {
        TrieNode curr = root;
        for (final char ch : word.toCharArray()) {
            final int i = ch - 'a';
            if (curr.children[i] == null) {
                curr.children[i] = new TrieNode();
            }
            curr = curr.children[i];
        }
        curr.isWord = true;
    }

    public boolean search(final String word) {
        return search(word, root, 0);
    }

    private boolean search(final String word, final TrieNode root, final int startIndex) {
        TrieNode curr = root;
        for (int i = startIndex; i < word.length(); i++) {
            final char ch = word.charAt(i);
            if (ch == WILDCARD) {
                for (final TrieNode child : curr.children) {
                    if (child != null && search(word, child, i + 1)) {
                        return true;
                    }
                }
                return false;
            } else {
                if (curr.children[ch - 'a'] == null) {
                    return false;
                }
                curr = curr.children[ch - 'a'];
            }   
        }
        return curr.isWord;
    }

    private static class TrieNode {
        final TrieNode[] children = new TrieNode[26];
        boolean isWord = false;
    }
}