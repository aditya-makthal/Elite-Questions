/*
Basanthi interested playing with digits.
He wants create a set of integers of length N, using the digits[0-9].
The rules to create the integers are as follows:
	- digits in each integer are like d0,d1,d2...dn-1
	- and |d0-d1| = |d1-d2| = |d2-d3| ... |dn-2 - dn-1|= D

Basanthi is given two integers N and D, where N is length of the integer and 
D is the difference. Can you help Basanthi, to create such list of integers 
and print all the possible integers in ascending order


Note:
-----
Integers with leading 0's are not allowed


Input Format:
-------------
Two space separated integers N and K.

Output Format:
--------------
Print all the possible integers in ascending order.


Sample Input-1:
---------------
3 6

Sample Output-1:
----------------
[171, 282, 393, 606, 717, 828, 939]


Sample Input-2:
---------------
2 3

Sample Output-2:
----------------
[14, 25, 30, 36, 41, 47, 52, 58, 63, 69, 74, 85, 96]

*/

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            generateNumbers(n-1, i, d, result);
        }
        Collections.sort(result);
        System.out.println(result);
    }

    private static void generateNumbers(int n, int num, int d, List<Integer> result) {
        if (n == 0) {
            result.add(num);
            return;
        }
        int lastDigit = num % 10;
        if (lastDigit + d <= 9) {
            generateNumbers(n-1, num*10 + lastDigit + d, d, result);
        }
        if (d != 0 && lastDigit - d >= 0) {
            generateNumbers(n-1, num*10 + lastDigit - d, d, result);
        }
    }
}
