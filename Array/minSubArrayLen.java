package Array;

public class minSubArrayLen {
    //Leetcode 209



    /** This code is so ugly. Need to rewrite.*/
    public static int solution(int s, int[] nums) {
        int n = nums.length;
        if (nums.length == 0)
            return 0;
        int p1 = 0;
        int p2 = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        while (p2 < n) {
            sum += nums[p2];
            while (sum >= s) {
                ans = Math.min(ans, p2 - p1 + 1);
                sum -= nums[p1];
                p1 ++;
            }
            p2 ++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static void main(String[] args) {
        int[] test = {10, 2, 3};
        System.out.println(solution(6, test));
    }
}
