package DFSandBFS;

public class solve {
    //Leetcode 130

    public static void solve(char[][] board) {
        if (board.length == 0)
            return;
        int m = board.length;
        int n = board[0].length;
        for (int r = 0; r < m; r ++) {
            for (int c = 0; c < n; c ++) {
                if (r == 0 || r == m - 1 || c == 0 || c == n - 1 && board[r][c] == 'O')
                    DFS(board, r, c);
            }
        }
        for (int r = 0; r < m; r ++) {
            for (int c = 0; c < n; c ++) {
                if (board[r][c] == 'T')
                    board[r][c] = 'O';
                else if (board[r][c] == 'O')
                    board[r][c] = 'X';
            }
        }
    }

    public static void DFS(char[][] board, int row, int col) {
        int m = board.length;
        int n = board[0].length;
        if (row < 0 || col < 0 || row >= m || col >=n || board[row][col] != 'O')
            return;
        board[row][col] = 'T';
        DFS(board, row + 1, col);
        DFS(board, row - 1, col);
        DFS(board, row, col + 1);
        DFS(board, row, col - 1);
    }
}
