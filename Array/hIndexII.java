package Array;

public class hIndexII {
    // Leetcode 275
    public static int solution(int[] citations) {
        int lo = 0;
        int n = citations.length;
        if (n == 0)
            return 0;
        int hi = n - 1;
        int mid;
        while (lo < hi) {
            mid = lo + (hi - lo) / 2;
            int kElements = n - mid;
            if (kElements > citations[mid]) {
                lo = mid + 1;
            } else if (kElements == citations[mid]) {
                return kElements;
            } else {
                hi = mid;
            }
        }
        if (n - lo <= citations[lo])
            return n - lo;
        return 0;
    }


    public static void main(String[] args) {
        int[] test = {0, 0};
        System.out.println(solution(test));
    }
}
