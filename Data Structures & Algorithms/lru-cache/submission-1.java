/**
 * A node intended for use in a doubly-linked list.
 */
 // TODO getters/setters
class Node {
    final int key;
    final int val;
    Node prev;
    Node next;

    /**
     * Constructor
     */
    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

/**
 * A least-recently used cache.
 * This object caches objects up to the provided [capacity].
 * If pushing an object exceeds the capacity, the least recently used object
 * will be removed from the cache.
 */
class LRUCache {
    private final Map<Integer, Node> cache;
    private final int capacity;
    private Node head = new Node(0, 0); // Least recently used
    private Node tail = new Node(0, 0); // Most recently used

    /**
     * Constructor
     */
    public LRUCache(final int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>(capacity);
        head.next = tail;
        tail.prev = head;
    }

    /**
     * Retrieves the item with the given [key] from the cache.
     * Returns -1 if the item with the given [key] does not exist.
     */
    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }

        final Node node = cache.get(key);
        remove(node);
        insert(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            remove(cache.get(key));
        }
        // Add the key, putting it in the most recently used (right) side of the double-linked list
        final Node newNode = new Node(key, value);
        cache.put(key, newNode);
        insert(newNode);

        // If the capacity is too large, trim the least-recently used object.
        if (cache.size() > capacity) {
            final Node lru = head.next;
            remove(lru);
            cache.remove(lru.key);
        }
    }

    private void insert(final Node node) {
        final Node prev = tail.prev;
        prev.next = node;
        node.prev = prev;
        node.next = tail;
        tail.prev = node;
    }

    private void remove(final Node node) {
        final Node prev = node.prev;
        final Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }
}
