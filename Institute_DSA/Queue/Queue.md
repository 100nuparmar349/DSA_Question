import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> convert(char[][] board) {
        List<String> li = new ArrayList<>();
        for (int i = 0; i < board.length; i++) { // Changed j to i
            li.add(new String(board[i])); // No need to create a new String here; use String.valueOf instead.
        }
        return li;
    }

    public boolean issafe(char[][] board, int i, int j, int n) {
        // Check the same column
        for (int k = 0; k < i; k++) {
            if (board[k][j] == 'Q') return false;
        }

        // Check the upper left diagonal
        for (int k = i - 1, l = j - 1; k >= 0 && l >= 0; k--, l--) {
            if (board[k][l] == 'Q') return false;
        }

        // Check the upper right diagonal
        for (int k = i - 1, l = j + 1; k >= 0 && l < n; k--, l++) {
            if (board[k][l] == 'Q') return false;
        }
        return true;
    }

    public void solve(List<List<String>> ans, char[][] board, int n, int i) {
        if (i == n) {
            ans.add(convert(board)); // Convert the board to List<String>
            return;
        }
        for (int j = 0; j < n; j++) {
            if (issafe(board, i, j, n)) {
                board[i][j] = 'Q'; // Place the queen
                solve(ans, board, n, i + 1); // Recur to place next queen
                board[i][j] = '.'; // Backtrack
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) { // Fixed loop condition
            for (int j = 0; j < n; j++) {
                board[i][j] = '.'; // Initialize the board
            }
        }
        solve(ans, board, n, 0);
        return ans; // Return the answer
    }
}
