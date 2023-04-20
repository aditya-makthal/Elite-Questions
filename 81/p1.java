/*
A merchant has two types of idols, gold and silver.
He has arranged the idols in the form of m*n grid, 
	- the gold idols are represented as 1's 
	- the silver idols are represented as 0's.

Your task is to find the longest consecutive arrangement of gold idols, 
The arrangement can be either horizontal, vertical, diagonal or 
antidiagonal, but not the combination of these.


Input Format:
-------------
Line-1: Two space separated integers m and n, grid size.
Next m lines : n space separated integers, arrangement of idols.

Output Format:
--------------
Print an integer, longest arranement of gold idols.


Sample Input:
---------------
4 5
1 0 1 1 1
0 1 0 1 0
1 0 1 0 1
1 1 0 1 1

Sample Output:
----------------
4

*/
import java.util.*;
class Solution{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[][] arr = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(solve(arr, n,m ));
    }
    static int solve(int[][] arr, int n, int m){
        int[][] dp = new int[n][m];
        int[][] dp0 = new int[n][m];
        int[][] dp1 = new int[n][m];
        int[][] dp2 = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]==1){
                    dp[i][j] = 1;
                    dp0[i][j] = 1;
                    dp1[i][j] = 1;
                    dp2[i][j] = 1;
                }
            }
        }
        int mx = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            for(int j=1;j<m;j++){
                if(arr[i][j]==1){
                    dp[i][j] = 1+dp[i][j-1];
                    mx = Math.max(dp[i][j], mx);
                }
            }
        }
        for(int j=0;j<m;j++){
            for(int i=1;i<n;i++){
                if(dp0[i][j]==1){
                    dp0[i][j] = 1 + dp0[i-1][j];
                    mx = Math.max(dp0[i][j], mx);
                }
            }
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(arr[i][j]==1){
                    dp1[i][j] =1+dp1[i-1][j-1];
                    mx = Math.max(dp1[i][j], mx);
                }
            }
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<m-1;j++){
                if(arr[i][j]==1){
                    dp2[i][j] = 1+dp2[i-1][j+1];
                    mx = Math.max(dp2[i][j], mx);
                }
            }
        }
        return mx;
    }
}