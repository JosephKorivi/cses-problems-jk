/*

        Time limit: 1.00 s
        Memory limit: 512 MB



        Given a string, your task is to reorder its letters in such a way that it becomes a palindrome (i.e., it reads the same forwards and backwards).
        Input
        The only input line has a string of length n consisting of characters A–Z.
        Output
        Print a palindrome consisting of the characters of the original string. You may print any valid solution. If there are no solutions, print "NO SOLUTION".
        Constraints

        1 <= n <= 10^6

        Example
        Input:
        AAAACACBA

        Output:
        AACABACAA


 */

package IntroductoryProblems;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PalindromeReorder {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // Reading input from the user
        String str = br.readLine();
        int stringLength = str.length();

        // Initializing the HashMap to Store the Frequency of the Characters
        HashMap<Character, Integer> freq = new HashMap<>();

        // Count character frequencies
        for (char c : str.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        // Count characters with odd frequencies
        int oddCount = 0;
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                oddCount++;
            }
        }

        // According to the ALGO :  --> If more than one odd character exists, palindrome is impossible
        if (oddCount > 1) {
            bw.write("NO SOLUTION\n");
        } else {
            // Construct first half of the palindrome
            StringBuilder firstHalf = new StringBuilder();
            StringBuilder oddPart = new StringBuilder();

            for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
                char c = entry.getKey();
                int count = entry.getValue();

                // If character count is even, add half to firstHalf
                for (int i = 0; i < count / 2; i++) {
                    firstHalf.append(c);
                }

                // If it's the odd character, store it separately
                if (count % 2 == 1) {
                    oddPart.append(c);
                }
            }

            // Construct full palindrome
            StringBuilder palindrome = new StringBuilder(firstHalf);
            palindrome.append(oddPart);
            palindrome.append(firstHalf.reverse());

            bw.write(palindrome + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
