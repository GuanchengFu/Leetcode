package Array;

public class rotate {
    // Leetcode 189
    public static void sol1(int[] nums, int k) {
        int length = nums.length;
        k = k % length;
        if (k == 0)
            return;
        boolean lengthEven = (length % 2 == 0);
        boolean kEven = (k % 2 == 0);
        if (lengthEven && kEven) {
            for (int j = 0; j <= 1; j ++) {
                int temp = nums[(j - k + length) % length];
                for (int i = j; i < length; i += k) {
                    int temp2 = nums[i];
                    nums[i] = temp;
                    temp = temp2;
                }
            }
        } else {
            int temp = nums[(0 - k + length) % length];
            int index = 0;
            for (int i = 0; i <  length; i += 1) {
                int temp2 = nums[index];
                nums[index] = temp;
                temp = temp2;
                index = (index + k) % length;
            }
        }
    }
    /**
     * Trivial solution, use k*N time and O(1) space.*/
    public static void moveRight(int[] nums) {
        int length = nums.length;
        int temp = nums[length - 1];
        for (int i = 0; i < length; i ++) {
            int wow = nums[i];
            nums[i] = temp;
            temp = wow;
        }
    }

    public static void finalSol(int[] nums, int k) {
        int length = nums.length;
        k = k % length;
        int count = 0; // How many numbers have we already moved.
        //实际上整个循环是k次 ， start 代表的是0, 1, 2, 3.. k - 1
        for (int start = 0; count < length; start ++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count ++;
            } while (start != current);
        }
    }

    public static void main(String[] args) {
        int[] test = {1, 2, 3, 4, 5, 6, 7};
        finalSol(test, 3);
        for (int i = 0; i < test.length; i ++) {
            System.out.println(test[i]);
        }
    }


}
