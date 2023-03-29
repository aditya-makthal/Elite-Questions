// VishnuVardan is working with Binary Trees.
// Kishore is planned to flip the binary tree horizontally.

// The rules to flip the binary tree are as follows:
// 	- The original root node becomes the new right node.
// 	- The original left node becomes the new root node.
// 	- The original right node becomes the new left node.

// Your task is to help VishnuVardan to flip the tree horizontally with 
// given rule set.

// Your task is to implement the class Solution:
// 	- Node flipTree(Node root) : return the new root node.
// 	- List<List<Integer>> levelOrder(Node root)

// NOTE:
// - The mentioned rules are applied level by level
// - Every right node in the tree has a left node sharing the same parent
// - Every right node in the tree has no children

// In the given input '-1 indicates null node.

// Input Format:
// -------------
// Space separated integers, nodes of the tree.

// Output Format:
// --------------
// Print the list of nodes of flipped tree as described below.


// Sample Input-1:
// ---------------
// 4 2 3 5 1

// Sample Output-1:
// ----------------
// [[5],[1,2],[3,4]]


// Sample Input-2:
// ---------------
// 1 2 3 4 5 -1 -1 6 7

// Sample Output-2:
// ----------------
// [[6],[7,4],[5,2],[3,1]]

// For explanation look the hint

import java.util.*;

//Sample Binary tree Node sturcture for reference 

class Node {
    public int data;
    public Node left;
    public Node right;
    public Node(int value) {
        data = value;
        left = null;
        right = null;
    }
}
class p3 {
    Node flipTree(Node root){
        if (root == null)
            return root;
        if (root.left == null && root.right ==null)
            return root;
        Node flippedRoot=flipTree(root.left);
        root.left.left=root.right;
        root.left.right=root;
        root.left=root.right=null;
        return flippedRoot;
    }
    List<List<Integer>> levelOrder(Node root){
        List<List<Integer>> ans = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int n = q.size();
            List<Integer> al = new ArrayList<>();
            for(int i=0;i<n;i++){
                Node temp = q.poll();
                if(temp.left!=null){
                    q.add(temp.left);
                }
                if(temp.right!=null){
                    q.add(temp.right);
                }
                al.add(temp.data);
            }
            ans.add(al);
        }
        return ans;
    }
}
