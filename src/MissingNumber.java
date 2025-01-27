/*
    Time limit: 1.00 s
    Memory limit: 512 MB

    You are given all numbers between 1,2,... ,n except one. Your task is to find the missing number.
    Input
    The first input line contains an integer n.
    The second line contains n-1 numbers. Each number is distinct and between 1 and n (inclusive).
    Output
    Print the missing number.
    Constraints

    2 <= n <= 2.10^5

    Example
    Input:
    5
    2 3 1 5

    Output:
    4
*/

import java.util.Scanner;

public class MissingNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n < 2) {
            return;
        }
        int[] arr = new int[n - 1];
        long actualSum = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
            if (arr[i] < 1 || arr[i] > n) {
                return;
            }
            actualSum += arr[i];
        }
        long expectedSum = (long) n * (n + 1) / 2;
        System.out.println(expectedSum - actualSum);
    }
}
