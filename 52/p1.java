/*
There are n football players standing in the ground, coach wants to know the 
P'th largest height of the players. Given an array of heights[] and the value of P. 
Help the coach to find the P'th largest height.

Note: You are suppose to print the P'th largest height in the sorted order of heights[].
      Not the P'th distinct height.

Input Format:
-------------
Line-1: Size of array n and P value(space separeted)
Line-2: Array elements of size n.

Output Format:
--------------
Print P'th largest height.



Sample input-1:
---------------
8 2
1 2 1 3 4 5 5 5

Sample output-1:
----------------
5


Sample input-2:
---------------
6 3
2 4 3 1 2 5

Sample output-2:
----------------
3
*/

import java.util.*;
class Solution{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;++i){
            arr[i] = sc.nextInt();
        }
        System.out.println(solve(arr,n,k));
    }
    static int solve(int[] arr, int n, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i=0;i<n;++i){
            pq.offer(arr[i]);
        }
        while(--k>0){
            pq.poll();
        }
        return pq.poll();
    }
}