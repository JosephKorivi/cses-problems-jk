package IntroductoryProblems;

    /*
        A number spiral is an infinite grid whose upper-left square has number 1. Here are the first five layers of the spiral:

        Your task is to find out the number in row y and column x.
        Input
        The first input line contains an integer t: the number of tests.
        After this, there are t lines, each containing integers y and x.
        Output
        For each test, print the number in row y and column x.
        Constraints

        1 \le t \le 10^5
        1 \le y,x \le 10^9

        Example
        Input:
        3
        2 3
        1 1
        4 2

        Output:
        8
        1
        15
     */

import java.io.*;

public class NumberSpiral {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            String[] input = br.readLine().split(" ");
            long y = Long.parseLong(input[0]);
            long x = Long.parseLong(input[1]);

            long maxi = Math.max(x, y);
            long sq = (maxi - 1) * (maxi - 1);

            if (maxi % 2 == 0) {
                if (x > y) sb.append(sq + y).append("\n");
                else sb.append((maxi * maxi) - x + 1).append("\n");
            } else {
                if (x > y) sb.append((maxi * maxi) - y + 1).append("\n");
                else sb.append(sq + x).append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}

