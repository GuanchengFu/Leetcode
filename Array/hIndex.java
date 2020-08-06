package Array;

import java.util.Arrays;
import java.util.PriorityQueue;

public class hIndex {
    //Leetcode 274

    // 使用排序算法 O(nlogn) 复杂度
    public static int solution(int[] citations) {
        Arrays.sort(citations);
        int length = citations.length;
        if (length == 0)
            return 0;
        int h = 0;
        for (int i = length - 1; i >= 0; i --) {
            int value = citations[i];
            if (value > h) {
                h += 1;
            }
        }
        return h;
    }

    // 使用priorityqueue 可以达到O(n)复杂度 使用O(n) 得空间
    public static int solutionII(int[] citations) {
        PriorityQueue<Integer> temp = new PriorityQueue<>();
        for (int i = 0; i < citations.length; i ++) {
            int value = citations[i];
            if (value > temp.size()) {
                if (temp.isEmpty()) {
                    // This is the first element
                    temp.add(value);
                } else {
                    int number = temp.peek();
                    if (number <= temp.size()) {
                        temp.poll();
                    }
                    temp.add(value);
                }
            }
        }
        return temp.size();
    }

    /**
     * First, generalize the array.*/
    public static int solutionIII(int[] citations) {
        int n = citations.length;
        // If n = 5, then papers value are 0 , 1, 2, 3, 4, 5. which have 6 values.
        int[] papers = new int[n + 1];
        for (int c:citations) {
            papers[Math.min(n, c)] += 1;

        }
        //累加papers 进行比较
        int sk = papers[n];
        int k = n;
        while (sk < k && k >= 0) {
            sk += papers[--k];
        }
        return k;
    }

    public static void main(String[] args) {
        int[] test = {3,0,6,1,5,4,4};
        System.out.println(solutionIII(test));
    }
}
