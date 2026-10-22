class LRUCache {

    private final Map<Integer, Node> cache = new HashMap<>();
    private final int capacity;
    private final Node head = new Node(0, 0); // Most recent
    private final Node tail = new Node(0, 0); // Least recent

    public LRUCache(final int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(final int key) {
        if (cache.containsKey(key)) {
            final Node node = cache.get(key);
            remove(node);
            append(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(final int key, final int value) {
        if (cache.containsKey(key)) {
            remove(cache.get(key));
        }

        final Node newNode = new Node(key, value);
        cache.put(key, newNode);
        append(newNode);

        if (cache.size() > capacity) {
            final Node lru = tail.prev;
            remove(lru);
            cache.remove(lru.key);
        }
    }

    private void remove(final Node node) {
        final Node prev = node.prev;
        final Node next = node.next;
        prev.next = next;
        next.prev = prev;
        node.next = null;
        node.prev = null;
    }

    private void append(final Node node) {
        final Node tmp = head.next;
        node.prev = head;
        node.next = tmp;
        tmp.prev = node;
        head.next = node;
    }

    private static class Node {
        private Node next;
        private Node prev;
        private int key;
        private int val;

        private Node(final int key, final int val) {
            this.key = key;
            this.val = val;
        }
    }
}
