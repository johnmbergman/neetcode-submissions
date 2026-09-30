/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int kthSmallest(final TreeNode root, final int k) {
        final Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;
        int i = 0;
        while (curr != null || !stack.isEmpty()) {
            // Walk the left
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            // curr is null so pop
            curr = stack.pop();
            if (++i == k) {
                return curr.val;
            }
            curr = curr.right;
        }

        throw new RuntimeException("No solution");
    }
}
