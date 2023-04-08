/*
In a class of XII, computer teacher asked one of the student 
to perform a task as practical session .

There is a box contains N balls in it, each ball is printed 
with a positive integer. The teacher ask the student to split 
all the balls in the box into ball-groups,
each group should contain exatly S balls.

The student has to pick the ball-groups as follows:
	- the balls should be numbered consecutively.
	e.g., 1,2 3, 4 or 4,5,6,7 etc.

Finally, the student should say whether it is possible to 
split all the balls in the box, into ball-groups accordingly.

Now, its your task to help the student to find whether it is possible or not.
if possible, print "true".
otherwise, print "false".


Input Format:
-------------
Line-1: Two integers N and S, number of balls and size of ball-group.
Line-2: N space separated integers, integers printed on each ball.

Output Format:
--------------
Print a boolean value, whether it is possible to split all the balls into groups.


Sample Input-1:
---------------
8 4
2 6 3 4 3 5 4 5

Sample Output-1:
----------------
true

Explanation:
-------------
Ball-groups are [2,3,4,5] and [3,4,5,6]


Sample Input-2:
---------------
12 3
12 2 9 5 3 4 13 7 6 8 11 7

Sample Output-2:
----------------
true

Explanation:
-------------
Ball-groups are [2,3,4], [5,6,7], [7,8,9] and [11,12,13]


Sample Input-3:
---------------
6 3
2 5 7 3 4 8

Sample Output-3:
----------------
false

Explanation:
-------------
you cannot form ball groups.

*/
import java.util.*;
class Solution{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        Map<Integer, Integer> hm = new HashMap<>();
        for(int i=0;i<n;i++){
            int temp = sc.nextInt();
            hm.put(temp, hm.getOrDefault(temp,0)+1);
        }
        System.out.println(solve(hm,m));
    }
    static boolean solve(Map<Integer, Integer> hm, int m){
        ArrayList<Integer> al = new ArrayList<>();
        al.addAll(hm.keySet());
        Collections.sort(al);
        int ind = 0, n = al.size();
        while(ind<n){
            int cnt = 0, val = al.get(ind);
            while(cnt<m && ind<n && hm.getOrDefault(val,0)>0){
                hm.put(val, hm.get(val)-1);
                ++cnt;
                ++val;
            }
            if(cnt<m){
                return false;
            }
            while(ind<n && hm.get(al.get(ind))==0){
                ++ind;
            }
        }
        return true;
    }
}