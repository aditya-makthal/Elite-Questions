/*
Brahmi and his gang was chased by group of police officers, unfortunately 
they all got locked up in a building consist of M*N rooms in the form of 
a grid. All the rooms are connected with  the adjacent rooms both horizontally
and vertically. There are few rooms for them to escape called as safe zones. 

Now help Brahmi and his gang to reach the safe zones in the building.

In the Building we have the rooms filled with following values: [0,-1,-2] 
where, -1 -> Danger zone (they should not enter into it).
0 -> Safe Zone (room to escape)
-2 -> a thief

Now create a method to print the grid after performing following step: 
Fill each room with one of the member from The Brahmi and his gang with 
the distance to its nearest safe zone.
If it is impossible to reach a safezone, fill with '-2' only.

Input Format:
-------------
Line-1 -> two integers M and N, size of the grid of rooms.
Next M Lines -> N space separated integers, from this set [-2,-1,0] only.

Output Format:
--------------
Print an integer as result.


Sample Input-1:
---------------
4 4
-2 -1 0 -2
-2 -2 -2 -1
-2 -1 -2 -1
0 -1 -2 -2

Sample Output-1:
----------------
3 -1 0 1
2 2 1 -1
1 -1 2 -1
0 -1 3 4
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
        solve(arr,n,m);
    }
    static void solve(int[][] arr, int n, int m){
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]==0){
                    bfs(arr, i, j, n, m);
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    static void bfs(int[][] arr, int x, int y, int n, int m){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y});
        int steps = 0;
        boolean[][] vis = new boolean[n][m];
        while(!q.isEmpty()){
            int sz = q.size();
            for(int k=0;k<sz;k++){
                int[] temp = q.poll();
                int i = temp[0], j = temp[1];
                vis[i][j] = true;
                arr[i][j] = arr[i][j]==-2?steps:Math.min(steps, arr[i][j]);
                int[] dir = new int[]{0,1,0,-1,0};
                for(int l=0;l<4;l++){
                    int a = i+dir[l], b = j +dir[l+1];
                    if(a>=0 && b >=0 && a<n && b<m && !vis[a][b] && arr[a][b]!=-1){
                        q.offer(new int[]{a,b});
                    }
                }
            }
            ++steps;
        }
    }
}