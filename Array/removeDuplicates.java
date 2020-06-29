package Array;

public class removeDuplicates {
    //Leetcode 26. Almost the same to Leetcode 27
    public static int solution(int nums[]) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int ans = 1;
        int value = nums[0];
        for (int i =1; i < nums.length; i ++) {
            if (nums[i] != value) {
                nums[ans] = nums[i];
                value = nums[i];
                ans += 1;
            }
        }
        return ans;
    }
}
