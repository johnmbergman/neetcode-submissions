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
    public ListNode reverseList(final ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;

        ListNode left = null;
        ListNode middle = head;
        ListNode right = head.next;

        while (right != null) {
            middle.next = left;
            left = middle;
            middle = right;
            right = right.next;
        }

        middle.next = left;

        return middle;
    }
}
