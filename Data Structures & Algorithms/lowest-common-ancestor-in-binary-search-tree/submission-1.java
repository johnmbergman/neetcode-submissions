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
    public TreeNode lowestCommonAncestor(final TreeNode root, final TreeNode p, final TreeNode q) {
        final int smaller = Math.min(p.val, q.val);
        final int larger = Math.max(p.val, q.val);

        TreeNode curr = root;

        // loop
        while (curr != null) {
            final int val = curr.val;
            if (smaller == val || larger == val) return curr;
            if (smaller < val && larger < val) {
                curr = curr.left;
            } else if (smaller > val && larger > val) {
                curr = curr.right;
            } else {
                return curr;
            }
        }

        return curr;
    }
}
