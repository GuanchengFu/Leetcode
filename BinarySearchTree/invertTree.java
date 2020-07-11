package BinarySearchTree;

public class invertTree {
    // Leetcode 226
    public TreeNode solution(TreeNode root) {
        if (root == null)
            return null;
        TreeNode temp = solution(root.right);
        root.right = solution(root.left);
        root.left = temp;
        return root;
    }
}
