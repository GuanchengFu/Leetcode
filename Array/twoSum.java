package Array;

import java.util.*;

public class twoSum {
    //Leetcode 167
    public static int[] twoSum(int[] numbers, int target) {
        int index1 = 0;
        int index2 = numbers.length - 1;
        for (int i = index2; numbers[i] > target; i--) {
            index2 = i;
        }
        while (numbers[index1] + numbers[index2] != target) {
            if (numbers[index1] + numbers[index2] > target) {
                index2 --;
            } else {
                index1 ++;
            }
        }
        int[] result = new int[2];
        result[0] = index1 + 1;
        result[1] = index2 + 1;
        return result;
    }


    // Leetcode 1
    public static int[] solutionAnother(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i ++) {
            for (int j = i + 1; j < nums.length; j ++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

    public static int[] improve1(int[] nums, int target) {
        // Use HashMap to reduce the time for operations.
        HashMap<Integer, List<Integer>> temp = new HashMap<>();
        for (int i = 0; i < nums.length; i ++) {
            if (temp.containsKey(nums[i])) {
                temp.get(nums[i]).add(i);
            } else {
                List<Integer> h = new ArrayList<>();
                h.add(i);
                temp.put(nums[i], h);
            }
        }
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i ++) {
            int another = target - nums[i];
            if (temp.containsKey(another)) {
                List<Integer> o = temp.get(another);
                if (another == nums[i]) {
                    if (o.size() > 1) {
                        result[0] = o.get(0);
                        result[1] = o.get(1);
                    }
                } else {
                    result[0] = i;
                    result[1] = o.get(0);
                }
            }
        }
        return result;
    }

    public static int[] officialMethod(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static int[] finalSol(int[] nums, int target) {
        Map<Integer, Integer> stl = new HashMap<>();
        for (int i = 0; i < nums.length; i ++) {
            int another = target - nums[i];
            if (stl.containsKey(another)) {
                return new int[] {stl.get(another), i};
            } else {
                stl.put(nums[i], i);
            }
        }
        throw new IllegalArgumentException("No such pairs");
    }


    public static void main(String[] args) {
        int[] test = {2,5,5,11};
        System.out.println(officialMethod(test, 10)[0]);
        System.out.println(officialMethod(test, 10)[1]);
    }
}
