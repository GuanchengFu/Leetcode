package BinarySearch;

public class basicBinarySearch {

    /**A basic implementation of the binary search algorithm.
     * @param target : The target that needs to be found.
     * A base case: low > high -- return -1
     * The search item is not in the array.*/
    public static int solution(int[] m, int lo, int hi, int target) {
        if (lo > hi)
            return -1;
        int mid = (hi + lo) / 2;
        if (m[mid] == target)
            return mid;
        else if (m[mid] < target)
            return solution(m, mid + 1, hi, target);
        else
            return solution(m, lo, mid - 1, target);
    }


    public static int iterateSol(int[] m, int target) {
        if (m.length == 0)
            return -1;
        int lo = 0;
        int hi = m.length - 1;
        int mid;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (m[mid] == target)
                return mid;
            else if (m[mid] < target)
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        return -1;
    }


    private int test(int k) {
        return k < 3? 1 : 1 + (k - 3) / 2;
    }

    public static void main(String[] args) {
        int[] test = {1, 2, 4, 5, 7, 9, 12};
        System.out.println(iterateSol(test, 5));
    }
}
