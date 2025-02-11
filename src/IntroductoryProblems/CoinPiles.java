

/*

            Time limit: 1.00 s
            Memory limit: 512 MB



            You have two coin piles containing a and b coins. On each move, you can either remove one coin from the left pile and two coins from the right pile, or two coins from the left pile and one coin from the right pile.
            Your task is to efficiently find out if you can empty both the piles.
            Input
            The first input line has an integer t: the number of tests.
            After this, there are t lines, each of which has two integers a and b: the numbers of coins in the piles.
            Output
            For each test, print "YES" if you can empty the piles and "NO" otherwise.
            Constraints

            1 <= t <= 10^5
            0 <= a, b <= 10^9

            Example
            Input:
            3
            2 1
            2 2
            3 3

            Output:
            YES
            NO
            YES

 */




    /* The below code also working fine but optimized due to very minute differences

        *The Time Complexity for this code is*
        for
      |-------------------------|
      | 1. TEST CASE --> 0.40   |
      | 2. TEST CASE --> 0.48   |
      | 3. TEST CASE --> 0.08   |
      |-------------------------|

        *Optimized Code Complexities*
      |-------------------------|
      | 1. TEST CASE --> 0.35   |
      | 2. TEST CASE --> 0.43   |
      | 3. TEST CASE --> 0.09   |
      |-------------------------|

        here is the *FIRST VERSION of the CODE

---------------------------------------------------------------------------------------------------------------------------------

        package IntroductoryProblems;

        import java.io.BufferedReader;
        import java.io.BufferedWriter;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.io.OutputStreamWriter;
        import java.util.ArrayList;
        import java.util.List;

        public class CoinPiles {
            public static void main(String[] args) throws IOException {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
                int t = Integer.parseInt(br.readLine().trim());
                List<List<Long>> list = new ArrayList<>();

                while (t-- > 0) {
                    String [] data = br.readLine().trim().split(" ");
                    long a = Long.parseLong(data[0]);
                    long b = Long.parseLong(data[1]);
                    list.add(List.of(a, b));
                }

                for (List<Long> lItem : list) {
                    long a = lItem.get(0);
                    long b = lItem.get(1);
                    if ((2 * a - b) % 3 != 0 || (2 * b - a) % 3 != 0 || (2 * a - b) < 0 || (2 * b - a) < 0) bw.write("No\n");
                    else bw.write("Yes\n");
                }

                bw.flush();
                br.close();
                bw.close();
            }
        }


*/
package IntroductoryProblems;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class CoinPiles {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String[] data = br.readLine().trim().split(" ");
            long a = Long.parseLong(data[0]);
            long b = Long.parseLong(data[1]);

            if ((a + b) % 3 == 0 && 2 * a >= b && 2 * b >= a) {
                bw.write("YES\n");
            } else {
                bw.write("NO\n");
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
