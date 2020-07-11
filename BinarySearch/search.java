package BinarySearch;

public class search {
    // Leetcode 33
    public static int solution(int[] nums, int target) {
        int n = nums.length;
        if (n == 0)
            return -1;
        int first = nums[0];
        boolean greater = false;
        if (target == first)
            return 0;
        else if (target > first)
            greater = true;
        int lo = 0;
        int hi = n - 1;
        while (lo <= hi) {
            int mid = lo + (hi-lo) / 2;
            int value = nums[mid];
            if (value >= first) {
                if (greater) {
                    if (value > target)
                        hi = mid - 1;
                    else if (value < target)
                        lo = mid + 1;
                    else
                        return mid;
                } else
                    lo = mid + 1;
            } else {
                if (greater) {
                    hi = mid - 1;
                } else {
                    if (value > target)
                        hi = mid - 1;
                    else if (value == target)
                        return mid;
                    else
                        lo = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] test = {4,5,6,7,0,1,2};
        System.out.println(solution(test, 3));
    }
}
