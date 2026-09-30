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

public class Codec {
    private static final String NULL_VALUE = "N";

    // Encodes a tree to a single string.
    public String serialize(final TreeNode root) {
        final StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(final TreeNode node, final StringBuilder sb) {
        if (node == null) {
            sb.append(NULL_VALUE).append(",");
            return;
        }

        sb.append(node.val).append(",");
        serialize(node.left, sb);
        serialize(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(final String data) {
        if (data == null || data.length() == 0) return null;
        final List<String> elements = Arrays.asList(data.split(","));
        final AtomicInteger i = new AtomicInteger();
        return deserialize(elements, i);
    }

    private TreeNode deserialize(final List<String> elements, final AtomicInteger i) {
        if (elements.get(i.get()).equals(NULL_VALUE)) {
            i.incrementAndGet();
            return null;
        }
        final TreeNode node = new TreeNode(Integer.parseInt(elements.get(i.get())));
        i.incrementAndGet();
        node.left = deserialize(elements, i);
        node.right = deserialize(elements, i);
        return node;
    }
}
