/*
There are N players, played a game.
You are given the scores of the N players as scores[] array,
where i-th player score is score[i].
You are given P chances to modify the score of the players.

In each chance you can modify the score of i-th (0 <= i < N) player as follows:
	- You are allowed increment the score of i-th player by 1.
You have to perform these increments, in order to maximize the occurences of any score.

Your task is to maximize occurences of a score, after utlizing atmost P chances.

Input Format:
-------------
Line-1: Two space separated integers N and P, Players count, and number of chances.
Line-2: N space separated integers, scores of N players scores[].

Output Format:
--------------
Print an integer, maximum occurences of a score!


Sample Input-1:
---------------
5 3
2 3 5 6 9

Sample Output-1:
----------------
2


Sample Input-2
---------------
6 5
2 3 4 6 8 9

Sample Output-2:
----------------
3
*/

import java.util.*;
class Solution{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int p=sc.nextInt();
        int [] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        Arrays.sort(arr);
        int fin=0;
        int cur=0;
        int temp=0;
        for(int i=n-1;i>0;i--){
            cur=0;
            temp=p;
            for(int j=i;j>=0;j--){
                if(temp-(arr[i]-arr[j])>=0){
                    temp=temp-(arr[i]-arr[j]);
                    cur++;
                }
                else{
                    break;
                }
            }
            fin=Math.max(fin,cur);
        }
        System.out.print(fin);
    }
}