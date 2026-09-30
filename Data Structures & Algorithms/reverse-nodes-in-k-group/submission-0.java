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
    public ListNode reverseKGroup(ListNode head, int k) {
        final ListNode origin = new ListNode(-1, head);

        ListNode groupPrev = origin;
        while (true) {
            final ListNode groupTail = getGroupTail(groupPrev, k);
            if (groupTail == null) break;

            final ListNode groupNext = groupTail.next;
            ListNode prev = groupTail.next;
            ListNode curr = groupPrev.next;
            while (curr != groupNext) {
                final ListNode tmp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = tmp;
            }
            
            final ListNode tmp = groupPrev.next;
            groupPrev.next = groupTail;
            groupPrev = tmp;
        }
        return origin.next;
    }

    private ListNode getGroupTail(ListNode node, int k) {
        while (node != null && k > 0) {
            node = node.next;
            k--;
        }
        return node;
    }
}
