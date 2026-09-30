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
    public void reorderList(final ListNode head) {
        ListNode list1 = head;
        ListNode list2 = reverse(splitAndGetSecondHalf(head));

        while (list1 != null && list2 != null) {
            final ListNode nextList1 = list1.next;
            final ListNode nextList2 = list2.next;

            list1.next = list2;
            list2.next = nextList1;
            list1 = nextList1;
            list2 = nextList2;
        }
    }

    // Reverses the linked list and returns the new head
    private ListNode reverse(final ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            final ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // Returns a head reference to the second half of the linked list.
    private ListNode splitAndGetSecondHalf(final ListNode head) {
        ListNode fast = head.next;
        ListNode slow = head;
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }

        if (fast != null) prev = prev.next;
        if (prev != null) prev = prev.next;

        return slow;
    }
}
