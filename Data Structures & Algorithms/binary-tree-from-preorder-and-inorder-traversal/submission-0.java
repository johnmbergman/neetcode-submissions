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
    final Map<Integer, Integer> indices = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            indices.put(inorder[i], i);
        }

        return buildTree(preorder, 0, inorder.length-1);
    }

    private TreeNode buildTree(final int[] preorder, final int l, final int r) {
        if (l > r) return null;
        final int rootValue = preorder[preorderIndex++];
        final TreeNode root = new TreeNode(rootValue);
        final int mid = indices.get(rootValue);
        root.left = buildTree(preorder, l, mid - 1);
        root.right = buildTree(preorder, mid + 1, r);
        return root;
    }
}
