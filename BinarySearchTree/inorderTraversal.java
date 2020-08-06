package BinarySearchTree;

import java.util.*;

public class inorderTraversal {

    //Leetcode 94
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderHelper(root, result);
        return result;
    }

    /**This function will add the elements in inorder sequence into the ref List.*/
    private static void inorderHelper(TreeNode root, List<Integer> ref) {
        if (root == null)
            return;
        inorderHelper(root.left, ref);
        ref.add(root.val);
        inorderHelper(root.right, ref);
    }

    public static List<Integer> iterateSol(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;
        /**ArrayDeque may have resizing problems, which will use more time.*/
        Deque<TreeNode> temp = new LinkedList<>();
        do {
            if (root == null) {
                root = temp.pollLast();
                // root 为中间的节点或者右边的节点，需要做出区分
                result.add(root.val);
                root = root.right;
            } else {
                temp.addLast(root);
                temp.addLast(root.right);
                root = root.left;
            }
        } while (!temp.isEmpty() || root != null);
        return result;
    }



    public static void main(String[] args) {
        TreeNode test = new TreeNode(1);
        test.right = new TreeNode(2);
        test.right.left = new TreeNode(3);
        iterateSol(test);
    }

}
