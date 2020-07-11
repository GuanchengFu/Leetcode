package BinarySearch;

public class searchInsert {
    //Leetcode 35

    public static int solution(int[] nums, int target) {
        if (nums.length == 0)
            return -1;
        if (target > nums[nums.length - 1])
            return nums.length;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target)
                lo = mid + 1;
            else
                hi = mid;
        }
        return lo;
    }

    public static void main(String[] args) {
        int[] test = {1, 3, 5, 6};
        System.out.println(solution(test, 7));
    }
}
