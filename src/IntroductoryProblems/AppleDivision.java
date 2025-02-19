
/*

                    Time limit: 1.00 s
            Memory limit: 512 MB



            There are n apples with known weights. Your task is to divide the apples into two groups so that the difference between the weights of the groups is minimal.
            Input
            The first input line has an integer n: the number of apples.
            The next line has n integers p_1,p_2,... ,p_n: the weight of each apple.
            Output
            Print one integer: the minimum difference between the weights of the groups.
            Constraints

            1 <= n <= 20
            1 <= p_i <= 10^9

            Example
            Input:
            5
            3 2 7 4 1

            Output:
            1

            Explanation: Group 1 has weights 2, 3 and 4 (total weight 9), and group 2 has weights 1 and 7 (total weight 8).


 */

package IntroductoryProblems;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class AppleDivision {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        long[] arr = new long[n];
        long totalSum = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(input[i]);
            totalSum += arr[i];  // Compute total sum
        }

        long minDiff = Long.MAX_VALUE;

        // Generate all subsets using bit masking
        for (int mask = 0; mask < (1 << n); mask++) {
            long subsetSum = 0;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {  // If the i-th element is included in subset
                    subsetSum += arr[i];
                }
            }
            long otherSubsetSum = totalSum - subsetSum;
            minDiff = Math.min(minDiff, Math.abs(subsetSum - otherSubsetSum));
        }

        bw.write(String.valueOf(minDiff));
        bw.newLine();
        bw.flush();
        br.close();
        bw.close();
    }
}
