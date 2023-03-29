// Pramod is working on Strings consist of digits only. He wants to findout, 
// whether the given string can form Fibonacci sequence or not.

// A String can form a Fibonacci Sequence, if it contains at least 
// three numbers, and numbers are in the following order:
// first, second, third  = first + second, fourth = third + second, .. so on.

// Return true, if the given string can form fibonacci sequence,
// otherwise, return false.

// Note: Numbers in the fibonacci sequence contains no leading 0's.
// for example, 2, 03,5 or 2,3,05 or 02,3,5 are not valid.

// Input Format:
// -------------
// A String consist of digits only

// Output Format:
// --------------
// Print a boolean value as result.


// Sample Input-1:
// ---------------
// 23581321

// Sample Output-1:
// ----------------
// true

// Explanation: 
// ------------
// Fibonacci Sequence is : 2, 3, 5, 8, 13, 21
// 2, 3, 2+3=5, 3+5=8, 5+8=13, 8+13=21.

// Sample Input-2:
// ---------------
// 199100199

// Sample Output-2:
// ----------------
// true

// Explanation: 
// ------------
// Fibonacci Sequence is : 1 99 100 199
// 1, 99, 1+99=100, 99+100=199.


import java.util.*;
import java.math.*;
public class p1 {
    public static boolean isFibonacci(String s) {
    int n = s.length();
    for (int i = 1; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            int k = j - i;
            if (j + Math.max(i, k) >= n) break; // No more numbers can be formed
            BigInteger a = new BigInteger(s.substring(0, i));
            BigInteger b = new BigInteger(s.substring(i, j));
            while (j + Math.max(i, k) <= n) {
                BigInteger sum = a.add(b);
                String sumStr = sum.toString();
                if (s.startsWith(sumStr, j)) {
                    if (j + sumStr.length() == n) return true;
                    a = b;
                    b = sum;
                    j += sumStr.length();
                } else {
                    break;
                }
            }
        }
    }
    return false;
}


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        boolean result = isFibonacci(str);
        System.out.println(result);
    }
}
