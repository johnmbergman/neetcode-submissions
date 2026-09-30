class PrefixTree {

    // Root node from which all searches begin
    // The character provided to the constructor should be ignored
    private final Node root = new Node('_');

    public void insert(final String word) {
        if (word == null) return;
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            curr = curr.insertAndNavigate(word.charAt(i));
        }
        curr.isWord = true;
    }

    public boolean search(final String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            final char ch = word.charAt(i);
            if (!curr.hasNext(ch)) return false;
            curr = curr.next(ch);
        }
        return curr.isWord;
    }

    public boolean startsWith(String prefix) {
        Node curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            final char ch = prefix.charAt(i);
            if (!curr.hasNext(ch)) return false;
            curr = curr.next(ch);
        }
        return true;
    }

    private static class Node {
        private final char ch;
        private final Map<Character, Node> next = new HashMap<>();

        private boolean isWord = false;

        private Node(final char ch) {
            this.ch = ch;
        }

        private boolean hasNext(final char ch) {
            return next.containsKey(ch);
        }

        private Node next(final char ch) {
            return next.get(ch);
        }

        private Node insertAndNavigate(final char ch) {
            return next.computeIfAbsent(ch, Node::new);
        }
    }
}
