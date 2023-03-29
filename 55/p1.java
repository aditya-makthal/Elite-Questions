/*
For X-Mas, santa claus is preparing a X-Mas Tree with set of Bulbs.
The bulbs are of different voltages, and preparation of tree as follows:
	- The bulbs are arranged in level-wise, levels are numbered from 0,1,2,3..
	  so on.
	- At level-0: There will be only one bulb as root bulb.,
	- From next level onwards, we have to attach two bulbs to left side,
	  and right side of every bulb in previous level.
	- At each level, there must be two bulbs attached to its previous level bulbs.
	- After the last level, there will be noe more bulbs attached.

You will be given the root of the X-Mas Tree (i.e.,perfect binary tree),
Your task is to return the root of the structure, after you reverse the bulbs
arrangement at ODD levels. 

Implement the class Solution:
1.public Node reverseValuesInOddLevel(Node root): returns the list of integers.


Input Format:
-------------
An integer, number of bulbs.
A single line of space separated integers, voltages of the set of N bulbs.

Output Format:
--------------
Print the list of voltages of the bulbs from the root.


Sample Input-1:
---------------
7
1 2 3 4 5 6 7

Sample Output-1:
----------------
1 3 2 4 5 6 7


Sample Input-2:
---------------
15
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15

Sample Output-2:
----------------
1 3 2 4 5 6 7 15 14 13 12 11 10 9 8
*/
/*
//TreeNode Structure for Your Reference..

class Node{
	public int data; 
	public Node left, right; 
	public Node(int data){
		this.data = data; 
		left = null; 
		right = null; 
	}
}

*/
import java.util.*;
class Solution {
    public Node reverseValuesInOddLevel(Node root) {
        Node rt = root;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        short isOdd = 0;
        while(!q.isEmpty()){
            int n = q.size(), ind = 0;
            int[] arr = new int[n];
            Node[] narr = new Node[n];
            for(int i=0;i<n;i++){
                Node temp = q.poll();
                arr[ind] = temp.data;
                narr[ind++] = temp;
                if(temp.left!=null){
                    q.offer(temp.left);
                }
                if(temp.right!=null){
                    q.offer(temp.right);
                }
            }
            if(isOdd == 1){
                for(int i=0;i<narr.length;++i){
                    narr[i].data = arr[n-i-1];
                }
            }
            isOdd ^= 1;
        }
        return rt;
    }
}
