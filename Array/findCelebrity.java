package Array;

public class findCelebrity {
    // Leetcode 277
    private int[][] wow;


    public findCelebrity(int[][] m) {
        wow = m;
    }

    public boolean knows(int a, int b) {
        return wow[a][b] == 1;
    }

    public int solution(int n) {
        int[] temp = new int[n];
        for (int i = 0; i < n; i ++) {
            temp[i] = i;
        }
        int last = n - 1;
        for (int i = 0; i < n - 1; i ++) {
            if (knows(temp[0], temp[1])) {
                int x = temp[0];
                temp[0] = temp[last];
                temp[last] = x;
                last -= 1;
            } else {
                int x = temp[1];
                temp[1] = temp[last];
                temp[last] = x;
                last -= 1;
            }
        }
        int possibleCelebrity = temp[0];
        for (int i = 0; i < n; i ++) {
            if (i != possibleCelebrity) {
                if (!knows(i, possibleCelebrity))
                    return -1;
                if (knows(possibleCelebrity, i))
                    return -1;
            }
        }
        return possibleCelebrity;
    }

    public static void main(String[] args) {
        int[][] test = {{1, 1, 0}, {0, 1, 0}, {1, 1, 1}};
        findCelebrity xd = new findCelebrity(test);
        System.out.println(xd.solution(3));
    }
}
