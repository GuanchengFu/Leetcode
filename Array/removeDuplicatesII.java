package Array;

public class removeDuplicatesII {
    //Leetcode 80

    public static int solution(int[] nums) {
        if (nums.length == 0 || nums == null)
            return 0;
        int answer = 0;
        int value;
        if (nums[0] == 0)
            value = -1;
        else
            value = 0;
        int times = 0;
        for (int i = 0; i < nums.length; i ++) {
            int temp = nums[i];
            if (temp == value) {
                times += 1;
                if (times <= 2) {
                    nums[answer] = temp;
                    answer += 1;
                }
            } else {
                value = temp;
                times = 1;
                nums[answer] = temp;
                answer += 1;
            }
        }
        return answer - 1;
    }

    public static int solutionII(int nums[]) {
        int length = nums.length;
        if (length <= 2)
            return length;
        int answer = 2;
        // nums at least have three elements.
        for (int i = 2; i < nums.length; i ++) {
            int value = nums[i];
            if (value > nums[answer - 2]) {
                nums[answer] = value;
                answer += 1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int nums[] = {1,1,1,2,2,3};
        for (int i = 0; i < solutionII(nums); i ++) {
            System.out.println(nums[i]);
        }
    }
}
