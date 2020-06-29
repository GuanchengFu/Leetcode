package Array;

class removeElement {
    //Leetcode 27

    /** Use two index pointers.
     *  One points to the beginning, one points to the last.*/
    public static int solution(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        int begin = 0;
        int last = nums.length - 1;
        while (begin <= last) {
            if (nums[begin] == val) {
                if (nums[last] != val) {
                    //Switch
                    nums[begin] = nums[last];
                    begin += 1;
                }
                last -= 1;
            } else {
                begin += 1;
            }
        }
        if (nums[0] == val)
            return 0;
        return last + 1;
    }

    /** From the same idea, but more simple than the previous code.*/
    public static int simpleSol(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        int start = 0;
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] != val) {
                nums[start] = nums[i];
                start += 1;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        int[] test = {3,2,2,3};
        int i = simpleSol(test, 2);
        for (int j = 0; j < i; j ++) {
            System.out.println(test[j]);
        }
    }
}