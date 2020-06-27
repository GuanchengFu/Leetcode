package Array;

class removeElement {
    public static int solution(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        int begin = 0;
        int last = nums.length - 1;
        while (begin <= last) {
            if (nums[begin] == val) {
                if (nums[last] == val) {
                    last -= 1;
                } else {
                    //Switch
                    nums[begin] = nums[last];
                    begin += 1;
                    last -= 1;
                }
            } else {
                begin += 1;
            }
        }
        if (nums[0] == val)
            return 0;
        return last + 1;
    }

    public static void main(String[] args) {
        int[] test = new int[0];
        int i = solution(test, 2);
        for (int j = 0; j < i; j ++) {
            System.out.println(test[j]);
        }
    }
}