package Array;

import java.util.ArrayList;
import java.util.List;

public class generate {
    // Leetcode 118

    public static List<List<Integer>> solution(int numRows) {

        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0)
            return result;
        for (int i = 1; i <= numRows; i ++) {
            List<Integer> temp = new ArrayList<>();
            if (i == 1) {
                temp.add(1);
            } else {
                List<Integer> ref = result.get(i - 2);
                for (int j = 0; j < i; j ++) {
                    if (j == 0)
                        temp.add(1);
                    else if (j == i - 1)
                        temp.add(1);
                    else {
                        temp.add(ref.get(j - 1) + ref.get(j));
                    }
                }
            }
            result.add(temp);
        }
        return result;
    }
}
