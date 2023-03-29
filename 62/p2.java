// Given an array of integer elements, ele[], YOur task is to find and print 
// the number of the subarrays, which gives you an even value after multiplication
// of the elements in it.

// Input Format:
// -------------
// Line-1: An integer N, number of elements.
// Line-2: Space separated elements.

// Output Format:
// --------------
// Print number of possible subarrays.


// Sample Input-1:
// ---------------
// 4
// 5 8 9 17

// Sample Output-1:
// ----------------
// 6

// Explanation:
// ------------
// 5 x 8 = 40
// 5 x 8 x 9 = 360
// 5 x 8 x 9 x 17 = 6120
// 8 = 8
// 8 x 9 = 72
// 8 x 9 x 17 = 1224
// Hence we got 6 even subarray multiplications.



// Sample Input-2:
// ---------------
// 3
// 5 7 11

// Sample Output-2:
// ----------------
// 0

// Explanation:
// ------------
// No subarrays which will give you even value after multiplication.

import java.util.*;
class p2{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;++i){
            arr[i] = sc.nextInt();
        }
        sc.close();
        System.out.println(solve(arr,n));
    }
    static int solve(int[] arr, int n){
        int tot = (int)((n*(n+1))/2), cnt = 0, temp = 0;
        for(int i=n-1;i>=0;--i){
            if(arr[i]%2==0){
                temp = 0;
            }
            else{
                ++temp;
                cnt += temp;
            }
        }
        return tot - cnt;
    }
}