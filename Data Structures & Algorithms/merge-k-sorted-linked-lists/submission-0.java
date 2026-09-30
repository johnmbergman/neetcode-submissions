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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) return null;
        final ListNode root = new ListNode();
        ListNode curr = root;

        while (true) {

            // Get the next index with min val
            int minIndex = -1;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] == null) continue;
                if (minIndex == -1|| lists[i].val < lists[minIndex].val) {
                    minIndex = i;
                }
            }

            if (minIndex == -1) break;

            // Insert the node
            curr.next = lists[minIndex];
            lists[minIndex] = lists[minIndex].next;
            curr = curr.next;
        }

        return root.next;
    }
}
