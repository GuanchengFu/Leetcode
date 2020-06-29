package Array;

public class minSubArrayLen {
    //Leetcode 209



    /** This code is so ugly. Need to rewrite.*/
    public static int solution(int s, int[] nums) {
        if (nums.length == 0 || nums == null)
            return 0;

        if (nums.length == 1) {
            if (nums[0] >= s)
                return 1;
            return 0;
        }

        if (nums.length == 2) {
            if (nums[0] >= s || nums[1] >= s)
                return 1;
            if (nums[0] + nums[1] >= s)
                return 2;
            return 0;
        }
        if (nums[0] >= s || nums[1] >= s)
            return 1;
        int p1 = 0;
        int p2 = 1;
        int sum = nums[p1] + nums[p2];
        int length = 2;
        int minimumL = length;
        while (p2 < nums.length - 1 && sum < s) {
            p2 += 1;
            length += 1;
            sum += nums[p2];
        }
        minimumL = length;
        while (p2 < nums.length - 1) {
            p2 += 1;
            length += 1;
            sum += nums[p2];
            while (sum - nums[p1] >= s) {
                sum -= nums[p1];
                p1 += 1;
                length -= 1;
                if (length < minimumL)
                    minimumL = length;
            }
        }
        while (sum - nums[p1] >= s) {
            sum -= nums[p1];
            p1 += 1;
            length -= 1;
            if (length < minimumL)
                minimumL = length;
        }
        if (sum < s)
            return 0;
        return minimumL;
    }

    public static void main(String[] args) {
        int[] test = {10, 2, 3};
        System.out.println(solution(6, test));
    }
}
