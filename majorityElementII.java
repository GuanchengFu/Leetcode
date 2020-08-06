import java.util.ArrayList;
import java.util.List;

public class majorityElementII {
    //Leetcode 229
    public static List<Integer> majorityElement(int[] nums) {
        int candidate1 = 0;
        int candidate2 = 0;
        int times1 = 0;
        int times2 = 0;
        for (int i = 0; i < nums.length; i ++) {
            int value = nums[i];
            if (times1 == 0 && (times2 == 0 || candidate2 != value)) {
                candidate1 = value;
                times1 += 1;
                continue;
            }
            if (times2 == 0 && candidate1 != value) {
                candidate2 = value;
                times2 += 1;
                continue;
            }
            if (value == candidate1) {
                times1 += 1;
            } else if (value == candidate2) {
                times2 += 1;
            } else {
                times1 -= 1;
                times2 -= 1;
            }
        }
        boolean first = !(times1 == 0);
        boolean second = !(times1 == 0);
        times1 = 0;
        times2 = 0;
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] == candidate1) {
                times1 += 1;
            }
            if (nums[i] == candidate2) {
                times2 += 1;
            }
        }
        List<Integer> result = new ArrayList<>();
        if (times1 > nums.length / 3 && first) {
            result.add(candidate1);
        }
        if (times2 > nums.length / 3 && second) {
            result.add(candidate2);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] test = {0,0,0};
        System.out.println(majorityElement(test));
    }
}
