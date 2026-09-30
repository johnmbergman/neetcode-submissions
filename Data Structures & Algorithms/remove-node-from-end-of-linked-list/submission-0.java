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
    public ListNode removeNthFromEnd(final ListNode head, final int n) {
        if (head == null) return head;
        final ListNode dummy = new ListNode(0, head);

        ListNode slow = dummy;
        ListNode fast = slow.next;
        for (int i = 0; i < n; i++) {
            if (fast == null) return head;
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return dummy.next;
    }
}
