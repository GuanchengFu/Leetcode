package Array;

import java.util.HashMap;
import java.util.Map;

public class majorityElement {
    // leetcode 169
    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> temp = new HashMap<>();
        for (int i = 0; i < nums.length; i ++) {
            int value = nums[i];
            temp.put(value, temp.getOrDefault(value, 0) + 1);
        }
        int biggestIndex = 0;
        int beginNumber = 0;
        for (Integer i: temp.keySet()) {
            if (temp.get(i) > beginNumber) {
                beginNumber = temp.get(i);
                biggestIndex = i;
            }
        }
        return biggestIndex;
    }

    public static void main(String[] args) {
        int[] test = {3, 2, 3};
        System.out.println(majorityElement(test));
    }
}
