package BinarySearch;

public class firstBadVersion {
    //Leetcode 278
    public static int firstBadVersion(int n) {
        int lo = 1;
        int hi = n;
        int m;
        while (lo < hi) {
            m = lo + (hi - lo) / 2;
            if (isBadVersion(m))
                hi = m;
            else
                lo = m+1;
        }
        return lo;
    }

    // Recursion version, but this has a problem -- This will cause the stack overflow error.
    // This is mainly because the Java does not implement the tail recursion technique.
    private static int helpFindVersion(int lo, int hi) {
        if (lo > hi)
            return -1;
        int mid = lo + (hi - lo) / 2;
        //需要考虑是否全是错误版本？
        if (isBadVersion(mid) == true) {
            //Base case: All versions are bad versions.
            if (mid == 1)
                return 1;
            if (isBadVersion(mid - 1) == false)
                return mid;
            else
                return helpFindVersion(lo, hi - 2);
        }
        else
            return helpFindVersion(mid + 1, hi);
    }

    public static int firstBadVersionIterate(int n) {
        int lo = 1;
        int hi = n;
        int mid;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (isBadVersion(mid) == true) {
                //Base case: All the versions are bad versions.
                if (mid == 1)
                    return 1;
                if (isBadVersion(mid - 1) == false)
                    return mid;
                else
                    hi = mid - 1;
            } else
                lo = mid + 1;
        }
        return -1;
    }

    public static boolean isBadVersion(int version) {
        if (version >= 14)
            return true;
        return false;
    }

    public static void main(String[] args) {

        System.out.println(firstBadVersionIterate(20));
    }
}
