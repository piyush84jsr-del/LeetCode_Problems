/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // If root is null, nothing to search
        if (root == null) {
            return null;
        }

        // If root is either p or q
        if (root == p || root == q) {
            return root;
        }

        // Search in left subtree
        TreeNode left = lowestCommonAncestor(root.left, p, q);

        // Search in right subtree
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // p and q are found on different sides
        if (left != null && right != null) {
            return root;
        }

        // Return whichever side contains p or q
        if (left != null) {
            return left;
        }

        return right;
    }
}