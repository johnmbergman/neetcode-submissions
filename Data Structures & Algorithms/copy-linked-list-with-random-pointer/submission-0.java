/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(final Node head) {
        final Map<Node, Node> pointers = new HashMap<>();

        // Pass 1: create all new nodes
        for (Node node = head; node != null; node = node.next) {
            pointers.put(node, new Node(node.val));
        }

        // Pass 2: update next and random values
        for (Node node = head; node != null; node = node.next) {
            pointers.get(node).next = pointers.get(node.next);
            pointers.get(node).random = pointers.get(node.random);
        }

        return pointers.get(head);
    }
}
