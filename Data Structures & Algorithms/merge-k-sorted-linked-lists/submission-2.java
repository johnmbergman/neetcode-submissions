/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(final ListNode[] lists) {
        if (lists == null) return null;
        final PriorityQueue<ListNode> heap = new PriorityQueue<>(Comparator.comparing(node -> node.val));

        // Push head of each onto heap
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                heap.add(lists[i]);
            }
        }

        final ListNode head = new ListNode();
        ListNode curr = head;
        while (!heap.isEmpty()) {
            final ListNode nextNode = heap.poll();
            curr.next = nextNode;
            curr = curr.next;
            if (nextNode.next != null) {
                heap.add(nextNode.next);
            }
        }

        return head.next;
    }
}
