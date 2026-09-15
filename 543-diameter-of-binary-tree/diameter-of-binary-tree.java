class Solution {
    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter;
    }

    public int height(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left = height(root.left);
        int right = height(root.right);

        // Longest path passing through this node
        diameter = Math.max(diameter, left + right);

        // Return height of this node
        return 1 + Math.max(left, right);
    }
}