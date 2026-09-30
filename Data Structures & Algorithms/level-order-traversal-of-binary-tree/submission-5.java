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
        final Deque<NodeWithDepth> q = new ArrayDeque<>();

        q.offer(new NodeWithDepth(root, 0));

        while (!q.isEmpty()) {
            final NodeWithDepth curr = q.poll();
            if (curr.node == null) continue;
            if (curr.depth == result.size()) result.add(new ArrayList<>());
            result.get(curr.depth).add(curr.node.val);
            q.offer(new NodeWithDepth(curr.node.left, curr.depth+1));
            q.offer(new NodeWithDepth(curr.node.right, curr.depth+1));
        }

        return result;
    }

    private static class NodeWithDepth {
        private final TreeNode node;
        private final int depth;

        private NodeWithDepth(final TreeNode node, final int depth) {
            this.node = node;
            this.depth = depth;
        }
    }
}
