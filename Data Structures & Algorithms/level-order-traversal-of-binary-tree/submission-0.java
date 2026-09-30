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
        final Map<Integer, List<TreeNode>> nodesByDepth = new HashMap<>();
        final Deque<NodeWithDepth> q = new ArrayDeque<>();

        q.offer(new NodeWithDepth(root, 0));

        while (!q.isEmpty()) {
            final NodeWithDepth curr = q.poll();
            if (curr.node == null) continue;
            nodesByDepth
                .computeIfAbsent(curr.depth, x -> new ArrayList<>())
                .add(curr.node);
            q.offer(new NodeWithDepth(curr.node.left, curr.depth+1));
            q.offer(new NodeWithDepth(curr.node.right, curr.depth+1));
        }

        final List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nodesByDepth.size(); i++) {
            result.add(i, new ArrayList<>());
            for (TreeNode node : nodesByDepth.get(i)) {
                result.get(i).add(node.val);
            }
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
