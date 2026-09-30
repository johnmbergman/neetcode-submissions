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
    public ListNode addTwoNumbers(final ListNode l1, final ListNode l2) {
        final ListNode root = new ListNode();
        ListNode curr = root;

        boolean carry = false;
        ListNode curr1 = l1;
        ListNode curr2 = l2;
        while (curr1 != null || curr2 != null) {
            final int carryVal = carry ? 1 : 0;
            final int curr1Val = curr1 == null ? 0 : curr1.val;
            final int curr2Val = curr2 == null ? 0 : curr2.val;
            final int rawSum = curr1Val + curr2Val + carryVal;
            carry = rawSum >= 10;
            final int sum = rawSum % 10; //rawSum >= 10 ? rawSum - 10 : rawSum;
            curr.next = new ListNode(sum);
            curr = curr.next;
            if (curr1 != null) curr1 = curr1.next;
            if (curr2 != null) curr2 = curr2.next;
        }

        if (carry) {
            curr.next = new ListNode(1);
        }

        return root.next;
    }
}
