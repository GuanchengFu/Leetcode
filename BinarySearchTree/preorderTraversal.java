package BinarySearchTree;

import com.sun.source.tree.Tree;

import java.util.*;

public class preorderTraversal {

    //Leetcode 144

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helperFunction(root, result);
        return result;
    }

    public static void helperFunction(TreeNode root, List<Integer> temp) {
        if (root == null)
            return;
        temp.add(root.val);
        helperFunction(root.left, temp);
        helperFunction(root.right, temp);
    }

    public static List<Integer> solutionII(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;
        // Use deque over stack.
        /**Reason: For one thing, it's more sensible in terms of inheritance.
         * The fact that Stack extends Vector is really strange, in my view.
         * Early in Java, inheritance was overused IMO - Properties being another example.
         * For me, the crucial word in the docs you quoted is consistent.
         * Deque exposes a set of operations which is all about being able to fetch/add/remove items from the start or end of a collection, iterate etc - and that's it. There's deliberately no way to access an element by position, which Stack exposes because it's a subclass of Vector.
         * Oh, and also Stack has no interface, so if you know you need Stack operations you end up committing to a specific concrete class, which isn't usually a good idea.*/
        Deque<TreeNode> stack = new ArrayDeque<>();
        boolean left = true;
        do {
            if (root == null) {
                root = stack.pollLast().right;
                left = false;
            } else {
                if (left) {
                    result.add(root.val);
                    stack.addLast(root);
                    root = root.left;
                } else {
                    result.add(root.val);
                    stack.addLast(root);
                    root = root.left;
                    left = true;
                }
            }
        } while(!stack.isEmpty() || root != null);
        return result;
    }
    /**递归的本质就是压栈，了解递归本质后就完全可以按照递归的思路来迭代。
     * 怎么压，压什么？压的当然是待执行的内容，后面的语句先进栈，所以进栈顺序就决定了前中后序。*/
    public static List<Integer> officialSol(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }

        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            output.add(node.val);
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
        }
        return output;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(8);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        List<Integer> result = solutionII(root);
        for (Integer i:result) {
            System.out.println(i);
        }
    }
}
