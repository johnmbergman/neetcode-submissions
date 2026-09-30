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
    int preorderIndex = 0;
    int inorderIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, Integer.MAX_VALUE);
    }

    private TreeNode buildTree(final int[] preorder, final int[] inorder, final int limit) {
        if (preorderIndex == preorder.length) return null;
        if (inorder[inorderIndex] == limit) {
            inorderIndex++;
            return null;
        }

        final int rootValue = preorder[preorderIndex++];
        final TreeNode root = new TreeNode(rootValue);
        root.left = buildTree(preorder, inorder, rootValue);
        root.right = buildTree(preorder, inorder, limit);
        return root;
    }
}
