package DFSandBFS;

import java.util.Deque;
import java.util.LinkedList;

public class wallsAndGates {


    private static int[][] directions = {{1,0}, {-1,0}, {0, 1}, {0,-1}};

    // Leetcode 286
    public static void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0)
            return;
        int rowLength = rooms.length;
        int colLength = rooms[0].length;
        for (int i = 0; i <= rowLength; i ++) {
            for (int j = 0; j <= colLength; j ++) {
                if (rooms[i][j] == 2147483647) {
                    rooms[i][j] = BFS(rooms, i, j);
                }
            }
        }
    }

    public static void DuoBFS(int[][] rooms) {
        int m = rooms.length;
        if (m == 0)
            return;
        int n = rooms[0].length;
        if (n == 0)
            return;
        Deque<int[]> points = new LinkedList<>();
        for (int i = 0; i < m ; i++) {
            for (int j = 0; j < n; j ++) {
                if (rooms[i][j] == 0)
                    points.addLast(new int[] {i, j});
            }
        }
        while (!points.isEmpty()) {
            int[] cor = points.pollFirst();
            int row = cor[0];
            int col = cor[1];
            for (int[] direction:directions) {
                int r = row + direction[0];
                int c = col + direction[1];
                if (r < 0 || c < 0 || r >= m || c >= n || rooms[r][c] != Integer.MAX_VALUE)
                    continue;
                rooms[r][c] = rooms[row][col] + 1;
                points.addLast(new int[] {r, c});
            }
        }
    }


    /**Return the value of the coordinate of the nearest gate.
     * row and column is the beginning point for searching.
     * If cannot reach the gate, return -1.
     * This method will not change the rooms array.*/
    private static int BFS(int[][] rooms, int row, int column){
        int rowLength = rooms.length;
        int colLength = rooms[0].length;
        // use this to store the distance
        int[][] temp = new int[rowLength][colLength];
        Deque<Integer> stack = new LinkedList<>();
        stack.addLast(row * colLength + column);
        while (!stack.isEmpty()) {
            int value = stack.pollFirst();
            row = value / colLength;
            column = value % colLength;
            for (int[] direction : directions) {
                int r = row + direction[0];
                int c = column + direction[1];
                if (r < 0 || c < 0 || r >= rowLength || c >= colLength || temp[r][c] != 0 || rooms[r][c] == -1)
                    continue;
                temp[r][c] = temp[row][column] + 1;
                if (rooms[r][c] == 0)
                    return temp[r][c];
                stack.addLast(r * colLength + c);
            }
        }
        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        int[][] test = {{2147483647,-1,0,2147483647},{2147483647,2147483647,2147483647,-1},{2147483647,-1,2147483647,-1},{0,-1,2147483647,2147483647}};
        DuoBFS(test);
    }
}
