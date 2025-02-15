

/*

                        Time limit: 1.00 s
                    Memory limit: 512 MB



                    The Tower of Hanoi game consists of three stacks (left, middle and right) and n round disks of different sizes. Initially, the left stack has all the disks, in increasing order of size from top to bottom.
                    The goal is to move all the disks to the right stack using the middle stack. On each move you can move the uppermost disk from a stack to another stack. In addition, it is not allowed to place a larger disk on a smaller disk.
                    Your task is to find a solution that minimizes the number of moves.
                    Input
                    The only input line has an integer n: the number of disks.
                    Output
                    First print an integer k: the minimum number of moves.
                    After this, print k lines that describe the moves. Each line has two integers a and b: you move a disk from stack a to stack b.
                    Constraints

                    1 \le n \le 16

                    Example
                    Input:
                    2

                    Output:
                    3
                    1 2
                    1 3
                    2 3

 */

package IntroductoryProblems;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.ArrayList;


public class TowersOfHanoi {

    private static void moveDisk (int diskNumber, List<int[]> moves, int sourcePole, int destinationPole, int auxilaryPole) {
        if (diskNumber == 1) {
            moves.add(new int[] {sourcePole, destinationPole});
            return;
        }
        moveDisk(diskNumber-1, moves, sourcePole, auxilaryPole, destinationPole);
        moves.add(new int[] {sourcePole, destinationPole});
        moveDisk(diskNumber-1, moves, auxilaryPole, destinationPole, sourcePole);
    }

    private static void towerOfHanoi (int numOfDisks) {
        List<int[]> moves = new ArrayList<>();

        // stack numbers are followed by 1, 2, 3.. i.e., stack_1, stack_2, stack_3
        // SourcePole, AuxilaryPole, DestinationPole.

        int sourcePole = 1, auxilaryPole = 2, destinationPole = 3;
        moveDisk (numOfDisks, moves, sourcePole, destinationPole, auxilaryPole);
        System.out.println(moves.size());
        for (int [] move : moves) {
            System.out.println(move[0] + " " + move[1]);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int numOfDisks = Integer.parseInt(br.readLine());
        towerOfHanoi (numOfDisks);
    }
}
