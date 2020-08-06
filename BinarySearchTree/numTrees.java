package BinarySearchTree;

import java.util.HashMap;
import java.util.Map;

public class numTrees {
    //Leetcode 96
    //本题的关键点在于1456 和 1234生成的不同的树的个数是一样的。
    // 长度：生成树的个数
    public static Map<Integer, Integer> cache = new HashMap<>();

    public static int solution(int n) {
        return helperFunction(n);
    }

    public static int helperFunction(int n) {
        if (!cache.containsKey(n)) {
            if (n == 0 || n == 1)
                return 1;
            int sum = 0;
            for (int i = 1; i <= n; i++) {
                int leftTree = helperFunction(i - 1);
                int rightTree = helperFunction(n - i);
                sum += leftTree * rightTree;
            }
            cache.put(n, sum);
        }
        return cache.get(n);
    }


    public static int officialSol(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;

        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }

    public static void main(String[] args) {
        System.out.println(solution(14));
        System.out.println(officialSol(18));
    }
}
