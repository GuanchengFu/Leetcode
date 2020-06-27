import java.util.Arrays;

public class Solution {
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int indice = 0;
        for (int i = indice; i <= nums.length - 2; i ++) {
            for (int j = indice + 1; j <= nums.length - 1; j ++) {
                if (nums[indice] + nums[j] == target) {
                    result[0] = indice;
                    result[1] = j;
                    return result;
                }
            }
            indice += 1;
        }
        return null;
    }

    public static int[] twoSum_sec(int[] nums, int target) {
        Arrays.sort(nums);
        int small_num = 0;
        int bigger_num = nums.length - 1;
        while(small_num < bigger_num) {
            int test = nums[small_num] + nums[bigger_num];
            if (test == target) {
                return new int[]{small_num, bigger_num};
            } else if (test < target) {
                small_num += 1;
            } else {
                bigger_num -= 1;
            }
        }
        return null;
    }

    
    public static void main(String[] args) {
        int test[] = new int[]{3, 2, 4};
        int target = 6;
        int result[] = Solution.twoSum_sec(test, target);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }
}
