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
    public int maxPathSum(final TreeNode root) {
        final AtomicInteger result = new AtomicInteger(root.val);
        dfs(root, result);
        return result.get();
    }

    private int dfs(final TreeNode node, final AtomicInteger result) {
        if (node == null) return 0;

        final int leftMax = Math.max(dfs(node.left, result), 0);
        final int rightMax = Math.max(dfs(node.right, result), 0);
        final int newMax = Math.max(result.get(), node.val + leftMax + rightMax);
        result.getAndSet(newMax);
        return node.val + Math.max(leftMax, rightMax);
    }
}
