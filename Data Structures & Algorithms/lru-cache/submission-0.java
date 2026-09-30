class LRUCache extends TypedLRUCache<Integer, Integer> {
    LRUCache(int capacity) {
        super(capacity);
    }

    int get(int key) {
        return super.get(key).orElse(-1);
    }
}

private class TypedLRUCache<K,V> {

    private final int capacity;
    private final Map<K, Node<K,V>> cache = new HashMap<>();
    private Node<K,V> left; // Least recently used
    private Node<K,V> right; // Most recently used


    public TypedLRUCache(int capacity) {
        this.capacity = capacity;
        this.left = new Node<K,V>(null, null);
        this.right = new Node<K,V>(null, null);
        this.left.next = this.right;
        this.right.prev = this.left;
    }

    public Optional<V> get(K key) {
        if (!cache.containsKey(key)) return Optional.empty();

        final Node<K,V> node = cache.get(key);
        remove(node);
        insert(node);
        return Optional.of(node.val);
    }
    
    public void put(K key, V value) {
        if (cache.containsKey(key)) {
            remove(cache.get(key));
        }

        final Node<K,V> newNode = new Node<K,V>(key, value);
        cache.put(key, newNode);
        insert(newNode);

        if (cache.size() > capacity) {
            final Node<K,V> leastRecentlyUsed = this.left.next;
            remove(leastRecentlyUsed);
            cache.remove(leastRecentlyUsed.key);
        }
    }

    private void remove(final Node<K,V> node) {
        final Node<K,V> prev = node.prev;
        final Node<K,V> next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void insert(final Node<K,V> node) {
        final Node<K,V> prev = this.right.prev;
        prev.next = node;
        node.prev = prev;
        node.next = this.right;
        this.right.prev = node;
    }

    private static class Node<K,V> {
        private final K key;
        private final V val;
        private Node next;
        private Node prev;

        private Node(final K key, final V val) {
            this.key = key;
            this.val = val;
        }
    }
}
