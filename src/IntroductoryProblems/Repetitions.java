package IntroductoryProblems;/*

    You are given a DNA sequence: a string consisting of characters A, C, G, and T. Your task is to find the longest repetition in the sequence. This is a maximum-length substring containing only one type of character.
    Input
    The only input line contains a string of n characters.
    Output
    Print one integer: the length of the longest repetition.
    Constraints

    1 <= n <= 10^6

    Example
    Input:
    ATTCGGGA

    Output:
    3
 */

import java.util.Scanner;
public class Repetitions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int count = 1, maxi = 1;
        int n = str.length();
        if (n < 1 || n > 1000000) return;
        for (int i = 0; i < n - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                count++;
            } else {
                maxi = Math.max(maxi, count);
                count = 1;
            }
        }
        maxi = Math.max(maxi, count);
        System.out.println(maxi);
    }
}