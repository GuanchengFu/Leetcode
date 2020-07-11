package Array;

import java.util.Arrays;

public class firstMissingPositive {
    //Leetcode 41

    /**
     * 主要思路，将对应得元素放入正确得数组位置。*/
    public static int solution(int[] nums) {
        // 打标记法
        int length = nums.length;
        // 清除原本数组中得负数元素
        for (int i = 0; i < length; i ++) {
            if (nums[i] <= 0)
                nums[i] = length + 1;
        }
        for (int i = 0; i < length; i ++) {
            int value = nums[i];
            if (value < 0)
                value = -1 * value;
            if (value > 0 && value <= length) {
                // 打标记
                if (nums[value - 1] >= 0)
                    nums[value - 1] = -1 * nums[value - 1];
            }
        }
        for (int i = 0; i < length; i ++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return length + 1;
    }

    //置换法
    public static int solution2(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            while (nums[i] > 0 && nums[i] <= length && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < length; i ++) {
            if (nums[i] != i + 1)
                return i + 1;
        }
        return length + 1;
    }


    public static void main(String[] args) {
        int[] test = {1, 2, 0};
        System.out.println(solution2(test));
    }
}
