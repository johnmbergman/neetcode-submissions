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
    public int goodNodes(TreeNode root) {
        if (root == null) return 0;

        return 1
            + goodNodes(root.left, root.val)
            + goodNodes(root.right, root.val);
    }

    private int goodNodes(TreeNode node, int biggest) {
        if (node == null) return 0;

        final int additionalValue = node.val >= biggest ? 1 : 0;
        final int newBiggest = Math.max(node.val, biggest);

        return additionalValue 
             + goodNodes(node.left, newBiggest)
             + goodNodes(node.right, newBiggest);
    }
}
