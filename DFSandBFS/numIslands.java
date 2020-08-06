package DFSandBFS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class numIslands {


    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int rowLength = grid.length - 1;
        int colLength = grid[0].length - 1;
        int result = 0;
        for (int i = 0; i <= rowLength; i ++) {
            for (int j = 0; j <= colLength; j ++) {
                if (grid[i][j] == '1') {
                    result += 1;
                    BFSinfect(grid, i, j);
                }
            }
        }
        return result;
    }


    /**Change all the 1 connected with (row, column) to 0.
     * Use the DFS algorithm to implement this.*/
    private static void DFSinfect(char[][] grid, int row, int column) {
        int rowLength = grid.length - 1;
        int colLength = grid[0].length - 1;
        if (row < 0 || row > rowLength || column < 0 || column > colLength) {
            return;
        }
        char val = grid[row][column];
        if (val == '0')
            return;
        grid[row][column] = '0';
        DFSinfect(grid, row + 1, column);
        DFSinfect(grid, row - 1, column);
        DFSinfect(grid, row, column + 1);
        DFSinfect(grid, row, column - 1);
    }

    /**Change all the 1 connected with (row, column) to 0.
     * Use the BFS algorithm to implement this.*/
    private static void BFSinfect(char[][] grid, int row, int column) {
        int rowLength = grid.length;
        int colLength = grid[0].length;
        Deque<Integer> stack = new LinkedList<>();
        stack.addLast(row * colLength + column);
        while (!stack.isEmpty()) {
            int value = stack.pollFirst();
            row = value / colLength;
            column = value % colLength;
            char val = grid[row][column];
            if (val == '1') {
                grid[row][column] = '0';
                if (row + 1 < rowLength) {
                    stack.addLast((row + 1) * colLength + column);
                }
                if (column + 1 < colLength) {
                    stack.addLast(row * colLength + column + 1);
                }
                if (row - 1 >= 0) {
                    stack.addLast((row - 1) * colLength + column);
                }
                if (column - 1 >= 0) {
                    stack.addLast(row * colLength + column - 1);
                }
            }
        }
    }


    public static void main(String[] args) {
        //char[][] test = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        char[][] test3 = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        //char[][] test2 = {{'1', '1', '0'}, {'0', '1', '0'}, {'0', '0', '0'}};
        int result = numIslands(test3);
        System.out.println(result);
    }
}
