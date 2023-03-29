// In a game  policeman on an m x n grid. The Policeman is initially located at the
// top-left corner (i.e., gr[0][0]) and thief is located at bottom-right corner . 
// The policeman tries to move to the bottom-right corner (i.e., gr[m - 1][n - 1]).
// The Policeman can only move either down or right at any point in time.

// Given the two integers m and n, return the number of possible unique paths that
// the policeman can take to reach the thief.


// Input Format
// ------------
// Line1: Two integers which denotes 2D array

// Output Format
// --------------
// An Integer no of possible paths

// Example 1:

// Input: m = 3, n = 2
// Output: 3
// Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
// 1. Right -> Down -> Down
// 2. Down -> Down -> Right
// 3. Down -> Right -> Down

// Example 2:
// Input: m = 3, n = 7
// Output: 28

import java.util.*;
class p2{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[][] dp = new int[n][m];
        for(int i=0;i<n;i++){
            dp[i][0] = 1;
        }
        for(int i=0;i<m;i++){
            dp[0][i] = 1;
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        System.out.println(dp[n-1][m-1]);
    }
}