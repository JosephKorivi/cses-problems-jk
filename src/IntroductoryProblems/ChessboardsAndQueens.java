/*
        Time limit: 1.00 s Memory limit: 512 MB
        Your task is to place eight queens on a chessboard so that no two queens are attacking each other. As an additional challenge, each square is either free or reserved, and you can only place queens on the free squares. However, the reserved squares do not prevent queens from attacking each other.

        How many possible ways are there to place the queens?

        Input
        The input has eight lines, and each of them has eight characters. Each square is either free (.) or reserved (*).

        Output
        Print one integer: the number of ways you can place the queens.

        Example
        Input:

        ........
        ........
        ..*.....
        ........
        ........
        .....**.
        ...*....
        ........
        Output:

        65

 */


package IntroductoryProblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChessboardsAndQueens {
    static int count = 0;
    static char[][] board = new char[8][8];
    static boolean[] occupiedCol = new boolean[8];     // Columns occupied
    static boolean[] occupiedPrimary = new boolean[15]; // Primary diagonals
    static boolean[] occupiedSecondary = new boolean[15]; // Secondary diagonals
    static void solve(int row) {
        if (row == 8) {
            count++;  // Found a valid placement
            return;
        }
        for (int col = 0; col < 8; col++) {
            if (board[row][col] == '*' || occupiedCol[col] || occupiedPrimary[row - col + 7] || occupiedSecondary[row + col]) {
                continue; // Skip invalid positions
            }
            // Place queen
            occupiedCol[col] = occupiedPrimary[row - col + 7] = occupiedSecondary[row + col] = true;
            solve(row + 1); // Recur to the next row
            // Backtrack
            occupiedCol[col] = occupiedPrimary[row - col + 7] = occupiedSecondary[row + col] = false;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 8; i++) {
            board[i] = br.readLine().toCharArray();
        }
        solve(0);
        System.out.println(count);
        br.close();
    }
}
