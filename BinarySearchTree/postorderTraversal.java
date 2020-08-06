package BinarySearchTree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class postorderTraversal {
    // Leetcode 145

    public static List<Integer> solution(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postHelper(root, result);
        return result;
    }
    private static void postHelper(TreeNode root, List<Integer> ref) {
        if (root == null)
            return;
        postHelper(root.left, ref);
        postHelper(root.right, ref);
        ref.add(root.val);
    }


    public static List<Integer> iterateSol(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;
        /**ArrayDeque may have resizing problems, which will use more time.*/
        Deque<TreeNode> temp = new LinkedList<>();
        TreeNode cur = root;
        temp.addLast(cur);
        while (!temp.isEmpty()) {
            cur = temp.pollLast();
            if (cur != null) {
                temp.addLast(cur);
                temp.addLast(null);
                if (cur.right != null)
                    temp.addLast(cur.right);
                if (cur.left != null)
                    temp.addLast(cur.left);
            } else {
                cur = temp.pollLast();
                result.add(cur.val);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(8);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        List<Integer> result = iterateSol(root);
        for (Integer i:result) {
            System.out.println(i);
        }
    }

}
