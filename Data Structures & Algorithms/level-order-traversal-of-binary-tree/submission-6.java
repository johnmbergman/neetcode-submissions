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
    public List<List<Integer>> levelOrder(final TreeNode root) {
        final List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        final Deque<TreeNode> q = new ArrayDeque<>();

        q.offer(root);

        while (!q.isEmpty()) {
            final int levelSize = q.size();
            final List<Integer> level = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                final TreeNode node = q.poll();
                level.add(node.val);
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }

            result.add(level);
        }

        return result;
    }
}
