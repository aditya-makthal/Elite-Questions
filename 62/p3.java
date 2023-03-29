// The heights of the students of two classes are given as h1[] and h2[],
// the student count of the classes are same. The task is to find 
// the sum of the product of heights of these two classes.

// For example, if h1 = [1,2,3,4] and h2 = [5,2,3,1], the sum of products would be
// 1*5 + 2*2 + 3*3 + 4*1 = 22.

// You are given two lists h1 and h2 of length n, return the minimum product sum 
// if you are allowed to rearrange the order of the elements in h1. 

// Sample Input-1:
// ---------------
// 4
// 5 3 4 2
// 4 2 2 5

// Sampe Output-1:
// ---------------
// 40

// Explanation:
// ------------
// We can rearrange h1 to become [3,5,4,2]. 
// The sum of products of [3,5,4,2] and [4,2,2,5] is 3*4 + 5*2 + 4*2 + 2*5 = 40.


// Sample Input-2:
// ---------------
// 5
// 2 1 4 5 7
// 3 2 4 8 6

// Sampe Output-2:
// ---------------
// 65

// Explanation:
// ------------
// We can rearrange h1 to become [5,7,4,1,2]. 
// The product sum of [5,7,4,1,2] and [3,2,4,8,6] is 
// 5*3 + 7*2 + 4*4 + 1*8 + 2*6 = 65.

import java.util.*;
class p3{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        for(int i=0;i<n;++i){
            arr1[i] = sc.nextInt();
        }
        for(int i=0;i<n;++i){
            arr2[i] = sc.nextInt();
        }
        System.out.println(solve(arr1,arr2,n));
    }
    static int solve(int[] arr1, int[] arr2, int n){
        int ans = 0;
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        for(int i=0;i<n;++i){
            ans += arr1[i]*arr2[n-i-1];
        }
        return ans;
    }
}