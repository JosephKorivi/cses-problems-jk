
/*

                Time limit: 1.00 s
                Memory limit: 512 MB



                Given a string, your task is to generate all different strings that can be created using its characters.
                Input
                The only input line has a string of length n. Each character is between a–z.
                Output
                First print an integer k: the number of strings. Then print k lines: the strings in alphabetical order.
                Constraints

                1 <= n <= 8

                Example
                Input:
                aabac

                Output:
                20
                aaabc
                aaacb
                aabac
                aabca
                aacab
                aacba
                abaac
                abaca
                abcaa
                acaab
                acaba
                acbaa
                baaac
                baaca
                bacaa
                bcaaa
                caaab
                caaba
                cabaa
                cbaaa

 */


/*

    This Problem will be solved using 3 Steps:

    1.  Generate Permutations
    2. Checking next Permutation
    3. Reversing of Permutations

 */

package IntroductoryProblems;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.TreeSet;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

public class CreatingStrings {
    static Set<String> permutations = new TreeSet<>();  // Maintains lexicographic order

    private static void generatePermutations(char[] arr, int index) {
        if (index == arr.length) {
            permutations.add(new String(arr));
            return;
        }
        Set<Character> used = new HashSet<>();
        for (int i = index; i < arr.length; i++) {
            if (used.contains(arr[i])) continue;
            used.add(arr[i]);
            swap(arr, index, i);
            generatePermutations(arr, index + 1);
            swap(arr, index, i);
        }
    }

    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        char[] arr = str.toCharArray();
        Arrays.sort(arr);  // Sort initially for lexicographic order

        generatePermutations(arr, 0);

        bw.write(permutations.size() + "\n");
        for (String s : permutations) {
            bw.write(s + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
