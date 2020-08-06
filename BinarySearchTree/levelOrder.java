package BinarySearchTree;

import com.sun.source.tree.Tree;
import edu.princeton.cs.algs4.In;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class levelOrder {

    // Leetcode 102

    /**Iterate version of level order traversal.
     * Use a stack implemented by Deque.
     * Stack is deprecated.*/
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        Deque<TreeNode> temp = new ArrayDeque<>();
        temp.addFirst(root);
        while (!temp.isEmpty()) {
            List<Integer> line = new ArrayList<>();
            int length = temp.size();
            for (int i = 0; i < length; i ++) {
                TreeNode t = temp.pollFirst();
                line.add(t.val);
                if (t.left != null) {
                    temp.addLast(t.left);
                }
                if (t.right != null) {
                    temp.addLast(t.right);
                }
            }
            result.add(line);
        }
        return result;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(0);

    }

}
