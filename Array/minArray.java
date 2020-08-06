package Array;

public class minArray {
    // Leetcode 剑指offer 11
    public static int minArray(int[] numbers) {
        if (numbers.length == 1)
            return numbers[0];
        int prev = numbers.length - 2;
        int cur = numbers.length - 1;
        while (prev >=0 && numbers[prev] <= numbers[cur]) {
            prev --;
            cur --;
        }
        return numbers[cur];
    }

    private static int solutionII(int[] numbers) {
        if (numbers.length == 0)
            return -1;
        int lo = 0;
        int hi = numbers.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (numbers[mid] < numbers[hi]) {
                hi = mid;
            } else if (numbers[mid] > numbers[hi]) {
                lo = mid + 1;
            } else {
                hi --;
            }
        }
        return numbers[lo];
    }

    public static void main(String[] args) {
        int[] test = {10,10,10,1,10};
        System.out.println(minArray(test));
    }
}
