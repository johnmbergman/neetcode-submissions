class PrefixTree {
    private final Node root = new Node();

    public void insert(final String word) {
        Node curr = root;
        for (final char c : word.toCharArray()) {
            curr.children.computeIfAbsent(c, x -> new Node());
            curr = curr.children.get(c);
        }
        curr.endOfWord = true;
    }

    public boolean search(final String word) {
        Node curr = root;
        for (final char c : word.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                return false;
            }
            curr = curr.children.get(c);
        }
        return curr.endOfWord;
    }

    public boolean startsWith(final String prefix) {
        Node curr = root;
        for (final char c : prefix.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                return false;
            }
            curr = curr.children.get(c);
        }
        return true;
    }

    private static class Node {
        final Map<Character, Node> children = new HashMap<>();
        boolean endOfWord = false;
    }
}
