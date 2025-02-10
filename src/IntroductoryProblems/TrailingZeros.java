


/*

            Time limit: 1.00 s
            Memory limit: 512 MB



            Your task is to calculate the number of trailing zeros in the factorial n!.
            For example, 20!=2432902008176640000 and it has 4 trailing zeros.
            Input
            The only input line has an integer n.
            Output
            Print the number of trailing zeros in n!.
            Constraints

            1 <= n <= 10^9

            Example
            Input:
            20

            Output:
            4

 */

package IntroductoryProblems;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class TrailingZeros {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long n = Long.parseLong(br.readLine());

        if (n < 1 || n > 1_00_00_00_000) return;

        long _5Count = 0, _2Count = 0;

        long current = n;

        while (current > 0) {
            _5Count += current / 5;
            current /= 5;
        }

        current = n;

        while (current > 0) {
            _2Count += current / 2;
            current /= 2;
        }

        long mini = Math.min(_5Count, _2Count);
        bw.write(Long.toString(mini));
        bw.flush();
        br.close();
        bw.close();
    }
}
