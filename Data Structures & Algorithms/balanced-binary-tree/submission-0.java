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
    public boolean isBalanced(TreeNode root) {
        return height(root).isBalanced;
    }

    private HeightAndBalance height(final TreeNode root) {
        if (root == null) return new HeightAndBalance(0, true);

        final HeightAndBalance left = height(root.left);
        final HeightAndBalance right = height(root.right);

        final int maxHeight = Math.max(left.height, right.height);
        final boolean isBalanced = Math.abs(left.height - right.height) <= 1
                                && left.isBalanced
                                && right.isBalanced;
        return new HeightAndBalance(maxHeight + 1, isBalanced);
    }

    private static class HeightAndBalance {
        private final int height;
        private final boolean isBalanced;

        public HeightAndBalance(final int height, final boolean isBalanced) {
            this.height = height;
            this.isBalanced = isBalanced;
        }
    }
}
