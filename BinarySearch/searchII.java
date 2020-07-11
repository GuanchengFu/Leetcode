package BinarySearch;

public class searchII {
    // Leetcode 81

    // This solution is ugly.
    public static boolean search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0)
            return false;
        int first = nums[0];
        boolean greater = false;
        if (target == first)
            return true;
        else if (target > first)
            greater = true;
        int lo = 0;
        int hi = n - 1;
        while (lo <= hi) {
            int mid = lo + (hi-lo) / 2;
            int value = nums[mid];
            if (value > first) {
                if (greater) {
                    if (value > target)
                        hi = mid - 1;
                    else if (value < target)
                        lo = mid + 1;
                    else
                        return true;
                } else
                    lo = mid + 1;
            } else if (value == first) {
                int temp = mid + 1;
                boolean flag = false;
                while (temp < n) {
                    if (nums[temp] != first) {
                        flag = true;
                        break;
                    }
                    temp += 1;
                }
                if (flag) {
                    if (greater) {
                        if (value > target)
                            hi = mid - 1;
                        else if (value < target)
                            lo = mid + 1;
                        else
                            return true;
                    } else
                        lo = mid + 1;
                } else {
                    if (greater)
                        hi = mid - 1;
                    else {
                        if (value > target)
                            hi = mid - 1;
                        else
                            lo = mid + 1;
                    }
                }

            } else {
                if (greater) {
                    hi = mid - 1;
                } else {
                    if (value > target)
                        hi = mid - 1;
                    else if (value == target)
                        return true;
                    else
                        lo = mid + 1;
                }
            }
        }
        return false;
    }

    private static boolean recurSol(int nums[], int lo, int hi, int target) {
        if (nums.length == 0)
            return false;
        int start = nums[lo];
        int end = nums[hi];
        if (lo > hi)
            return false;
        int length = hi - lo + 1;
        if (length == 0)
            return false;
        if (length == 1)
            return nums[lo] == target;
        if (start < end) {
            return basicBinarySearch.solution(nums, lo, hi, target) != -1;
        } else {
            int mid = lo + (hi - lo) / 2;
            return recurSol(nums, lo, mid, target) || recurSol(nums, mid + 1, hi, target);
        }
    }

    public static boolean solutionII(int nums[], int target) {
        return recurSol(nums, 0, nums.length - 1, target);
    }

    public static void main(String[] args) {
        int[] test = {1,1,2,2,0,0};
        System.out.println(solutionII(test, 0));
    }
}
