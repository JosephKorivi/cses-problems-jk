
/*

                    Time limit: 1.00 s
                    Memory limit: 512 MB



                    A Gray code is a list of all 2^n bit strings of length n, where any two successive strings differ in exactly one bit (i.e., their Hamming distance is one).
                    Your task is to create a Gray code for a given length n.
                    Input
                    The only input line has an integer n.
                    Output
                    Print 2^n lines that describe the Gray code. You can print any valid solution.
                    Constraints

                    1 <= n <= 16

                    Example
                    Input:
                    2

                    Output:
                    00
                    01
                    11
                    10


 */



package IntroductoryProblems;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class GrayCode {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        // 2^n using bitwise shift
        int totalNumbers = 1 << n;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < totalNumbers; i++) {
            // Convert to Gray Code
            int grayCode = i ^ (i >> 1);

            // Convert to n-bit binary string efficiently
            for (int j = n - 1; j >= 0; j--) {
                sb.append((grayCode >> j) & 1);
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
