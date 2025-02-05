//package IntroductoryProblems;

/*

        Your task is to count for k=1,2,...,n the number of ways two knights can be placed on a k \times k chessboard
        so that they do not attack each other.
        Input
        The only input line contains an integer n.
        Output
        Print n integers: the results.
        Constraints

        1 <= n <= 10000

        Example
        Input:
        8

        Output:
        0
        6
        28
        96
        252
        550
        1056
        1848

 */

import java.io.*;

public class TwoKnights {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (long i = 1; i <= n; i++) {
            long totalMoves = (i * i) * ((i * i) - 1) / 2;
            long attackingMoves = 4 * (i - 1) * (i - 2);
            sb.append(totalMoves - attackingMoves).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}

