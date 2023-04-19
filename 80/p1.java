/* 
In Dubai's Burj Khalifa, there is an elevator moves only in upwards direction, 
the elevator can carry N members.

The people are waiting for the elevator at different floors, made P requests, 
request[i] = [ num_people, enter_floor, exit_floor ], each request indicates, 
number of people to enter into elevator, entering floor number, 
exiting floor number.

Initially the elevator is empty.

Your task is to find and return true, iff it is possible to enter the people
into elevator and exit from elevator of all the requests made by the people.


Input Format:
-------------
Line-1 -> Two integers P and N, number of requests and number of members 
          can be carried by elevator.
Next N Lines -> three space separated integers, num_people, enter_floor, exit_floor.

Output Format:
--------------
Print a boolean value.


Sample Input-1:
---------------
2 5
2 1 5
3 3 7

Sample Output-1:
----------------
true



Sample Input-2:
---------------
2 4
2 1 5
3 3 7

Sample Output-2:
----------------
false



Sample Input-3:
---------------
3 11
3 2 7
3 7 9
8 3 9

Sample Output-3:
----------------
true

*/

import java.util.*;
class Solution{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), mx = 0;
        int[][] arr = new int[n][3];
        for(int i=0;i<n;i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
            arr[i][2] = sc.nextInt();
            mx = Math.max(mx, arr[i][2]);
        }
        System.out.println(solve(arr, n, m, mx));
    }
    static boolean solve(int[][] arr, int n, int m, int mx){
        int[] ans = new int[mx+1];
        for(int i=0;i<n;i++){
            for(int j=arr[i][1];j<arr[i][2];++j){
                ans[j] += arr[i][0];
            }
        }
        for(int i=0;i<=mx;i++){
            if(ans[i]>m){
                return false;
            }
        }
        return true;
    }
}