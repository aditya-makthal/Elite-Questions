/*
Somesh is working on Number Strings.
He got an idea to find the smallest possible number by 
deleting some digits from the number without changing 
the relative order of digits in it.

You will be given a integer String 'num', and an integer n.
Find the smallest number possible after deleting n digits from 'num'.

Note: If the number string 'num' turns to empty, print 0.

Input Format:
-------------
Line-1 : A string num, consist of digits only.
Line-2 : An integer n, number of digits to delete.

Output Format:
--------------
Print the smallest possible number.


Sample Input-1:
---------------
1432219
3

Sample Output-1:
----------------
1219

Explanation: 
------------
Delete the three digits 4, 3, and 2 to form the smallest number 1219.


Sample Input-2:
---------------
10200
1

Sample Output-2:
----------------
200

Explanation:
------------
Delete the leading 1 and the smallest number is 200. 
Note that the output must not contain leading zeroes.
*/
import java.util.*;
class Solution{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = sc.nextInt();
        System.out.println(solve(s,n));
    }
    static String solve(String num, int n){
        int k = num.length();
        if(k<=n){
            return "0";
        }
        List<Integer> digits = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            digits.add(num.charAt(i)-'0');
        }
        Stack<Integer> stack = new Stack<>();
        for (int digit : digits) {
            while (!stack.isEmpty() && n > 0 && stack.peek() > digit) {
                stack.pop();
                n--;
            }
            stack.push(digit);
        }
        while (n > 0) {
            stack.pop();
            n--;
        }
        while (!stack.isEmpty() && stack.get(0) == 0) {
            stack.remove(0);
        }
        if (stack.isEmpty()) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (int digit : stack) {
            sb.append(digit);
        }
        return sb.toString();
    }
}