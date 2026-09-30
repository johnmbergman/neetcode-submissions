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

    public int diameterOfBinaryTree(final TreeNode root) {
        final Map<TreeNode, DepthInfo> cache = new HashMap<>();
        cache.put(null, new DepthInfo(0, 0));
        final Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();

            if (node.left != null && !cache.containsKey(node.left)) {
                stack.push(node.left);
            } else if (node.right != null && !cache.containsKey(node.right)) {
                stack.push(node.right);
            } else {
                node = stack.pop();

                final DepthInfo leftData = cache.get(node.left);
                final DepthInfo rightData = cache.get(node.right);

                final int height = 1 + Math.max(leftData.height, rightData.height);
                final int diameter = Math.max(leftData.height + rightData.height, Math.max(leftData.diameter, rightData.diameter));
                cache.put(node, new DepthInfo(height, diameter));
            }
        }

        return cache.get(root).diameter;
    }

    private static class DepthInfo {
        final int height;
        final int diameter;

        private DepthInfo(final int height, final int diameter) {
            this.height = height;
            this.diameter = diameter;
        }
    }
}
