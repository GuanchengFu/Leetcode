package Array;

import java.util.ArrayList;
import java.util.List;

public class getRow {
    // Leetcode 119

    public static List<Integer> getRow(int rowIndex) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> prev = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        if (rowIndex == 0) {
            current.add(1);
            return current;
        }
        // current 是第i行，prev是第i-1行
        for (int i = 1; i <= rowIndex; i ++) {
            for (int j = 0; j <= i; j ++) {
                if (j == 0)
                    current.add(1);
                else if (j == i)
                    current.add(1);
                else {
                    current.add(prev.get(j - 1) + prev.get(j));
                }
            }
            prev = current;
            current = new ArrayList<>();
        }
        return prev;
    }
}

