package BinarySearchTree;
import java.util.Arrays;
public class sortedArrayToBST {
    //Leetcode 108
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
    }

    public static TreeNode solution(int nums[]) {
        int length = nums.length;
        if (length == 0)
            return null;
        int mid = (0 + nums.length - 1) / 2;
        TreeNode result = new TreeNode(nums[mid]);
        result.left = solution(Arrays.copyOfRange(nums, 0, mid));
        result.right = solution(Arrays.copyOfRange(nums, mid + 1, nums.length));
        return result;
    }

    public static void main(String[] args) {
        int[] test = {-10, -3, 0, 5, 9};
        solution(test);
    }
}
