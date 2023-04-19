// In an online magazine, every day they will ask their readers a puzzle.
// The puzzle has to be solved using the following rule set:
// 	- The puzzle is an 9*9 matrix, and consist of 9 -> 3*3 sub-matrices.
// 	- Each row in the puzzle should be filled with 1-9digits with out repetition
// 	- Each column in the puzzle should be filled with 1-9digits with out repetition.
// 	- Each 3*3 sub-matrix should be filled with 1-9 digits with out repetition.

// You will be given the puzzle in the form of 9 strings, each string length is 9.
// Your task is check whether the puzzle can be solved or not.
// If it is possible to solve, print "true". Otherwise print "false".


// Input Format:
// -------------
// 9 Lines: Each line consists of a string  length-9, consist of digits[1-9] and '.' only

// Output Format:
// --------------
// Print a boolean value.


// Sample Input-1:
// ---------------
// 53..7....
// 6..195...
// .98....6.
// 8...6...3
// 4..8.3..2
// 7...2...6
// .6....28.
// ...419..5
// ....8..79

// Sample Output-1:
// ----------------
// true


// Sample Input-2:
// ---------------
// 83..7....
// 6..195...
// .98....1.
// 8...6...3
// 4..8.3..1
// 7...2...6
// .6....28.
// ...419..5
// ....8..79

// Sample Output-2:
// ----------------
// false



import java.util.*;

public class p2 {
    public static boolean solvePuzzle(String[] puzzle) {
        for (int i = 0; i < 9; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                char c = puzzle[i].charAt(j);
                if (c != '.') {
                    if (set.contains(c)) {
                        return false;
                    } else {
                        set.add(c);
                    }
                }
            }
        }
        for (int j = 0; j < 9; j++) {
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < 9; i++) {
                char c = puzzle[i].charAt(j);
                if (c != '.') {
                    if (set.contains(c)) {
                        return false;
                    } else {
                        set.add(c);
                    }
                }
            }
        }
        for (int k = 0; k < 9; k++) {
            Set<Character> set = new HashSet<>();
            int iStart = (k / 3) * 3;
            int jStart = (k % 3) * 3;
            for (int i = iStart; i < iStart + 3; i++) {
                for (int j = jStart; j < jStart + 3; j++) {
                    char c = puzzle[i].charAt(j);
                    if (c != '.') {
                        if (set.contains(c)) {
                            return false;
                        } else {
                            set.add(c);
                        }
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] puzzle = new String[9];
        for (int i = 0; i < 9; i++) {
            puzzle[i] = sc.nextLine();
        }
        System.out.println(solvePuzzle(puzzle));
    }
}
