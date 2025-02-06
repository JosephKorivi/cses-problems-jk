
/*
        Your task is to divide the numbers 1,2, ...,n into two sets of equal sum.
        Input
        The only input line contains an integer n.
        Output
        Print "YES", if the division is possible, and "NO" otherwise.
        After this, if the division is possible, print an example of how to create the sets. First, print the number of elements in the first set followed by the elements themselves in a separate line, and then, print the second set in a similar way.
        Constraints

        1 <= n <= 10^6

        Example 1
        Input:
        7

        Output:
        YES
        4
        1 2 4 7
        3
        3 5 6
        Example 2
        Input:
        6

        Output:
        NO
 */



package IntroductoryProblems;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TwoSets {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        long sum = (long) n * (n + 1) / 2;

        // If sum is odd, it is impossible to divide it into two equal sets
        if (sum % 2 != 0) {
            bw.write("NO\n");
        } else {
            bw.write("YES\n");

            List<Integer> set1 = new ArrayList<>();
            List<Integer> set2 = new ArrayList<>();

            long target = sum / 2;
            long currentSum = 0;

            // Start picking numbers from largest to smallest
            for (int i = n; i > 0; i--) {
                if (currentSum + i <= target) {
                    set1.add(i);
                    currentSum += i;
                } else {
                    set2.add(i);
                }
            }

            // Print Set 1
            bw.write(set1.size() + "\n");
            for (int num : set1) {
                bw.write(num + " ");
            }
            bw.write("\n");

            // Print Set 2
            bw.write(set2.size() + "\n");
            for (int num : set2) {
                bw.write(num + " ");
            }
            bw.write("\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
