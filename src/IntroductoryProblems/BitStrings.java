
/*

                    Time limit: 1.00 s
                Memory limit: 512 MB



                Your task is to calculate the number of bit strings of length n.
                For example, if n=3, the correct answer is 8, because the possible bit strings are 000, 001, 010, 011, 100, 101, 110, and 111.
                Input
                The only input line has an integer n.
                Output
                Print the result modulo 10^9+7.
                Constraints

                1 <= n <= 10^6

                Example
                Input:
                3

                Output:
                8


 */




//package IntroductoryProblems;

import java.io.*;

public class BitStrings {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //  reading the input from user

        int n = Integer.parseInt(br.readLine());

        final long MOD = 1_00_00_00_007;
        long res = 1;

        for (int i=0; i<n; i++) {
            res = (res * 2) % MOD;
        }

        bw.write(Long.toString(res));
        bw.flush();
        br.close();
        bw.close();
    }
}
