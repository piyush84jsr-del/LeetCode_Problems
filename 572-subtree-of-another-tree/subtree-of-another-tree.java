class Solution {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        // If root becomes null, there is nowhere to find subRoot
        if (root == null) {
            return false;
        }

        // Check if the tree starting at current root
        // is exactly the same as subRoot
        if (sameTree(root, subRoot)) {
            return true;
        }

        // Otherwise search in left and right subtree
        return isSubtree(root.left, subRoot) ||
               isSubtree(root.right, subRoot);
    }

    public boolean sameTree(TreeNode root, TreeNode subRoot) {

        // Both are null -> both trees ended at the same time
        if (root == null && subRoot == null) {
            return true;
        }

        // One is null but the other isn't
        if (root == null || subRoot == null) {
            return false;
        }

        // Values are different
        if (root.val != subRoot.val) {
            return false;
        }

        // Both current values are equal,
        // so compare left and right children
        return sameTree(root.left, subRoot.left) &&
               sameTree(root.right, subRoot.right);
    }
}