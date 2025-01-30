/*

    You are given an array of n integers. You want to modify the array so that it is increasing, i.e., every element is at least as large as the previous element.
    On each move, you may increase the value of any element by one. What is the minimum number of moves required?
    Input
    The first input line contains an integer n: the size of the array.
    Then, the second line contains n integers x_1,x_2,...,x_n: the contents of the array.
    Output
    Print the minimum number of moves.
    Constraints

    1 <= n <= 2.10^5
    1 <= x_i <= 10^9

    Example
    Input:
    5
    3 2 5 1 7

    Output:
    5
 */


import java.util.Scanner;

public class IncreasingArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long [] arr = new long[n];

        // entering the array elements
        for (int i=0; i<n; i++) {
            arr[i] = sc.nextLong();
        }
        long res = findingMoves (arr, n);
        System.out.println(res);
    }

    private static long findingMoves(long[] arr, int n) {
        long moves = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i-1] > arr[i]) {
                moves += (arr[i-1] - arr[i]);
                arr[i] = arr[i-1];
            }
        }
        return moves;
    }
}
