import java.util.*;
import java.lang.*;
import java.io.*;

/*
The Longest Increasing Subsequence (LIS) problem is to find the length of the longest subsequence of a given sequence
such that all elements of the subsequence are sorted in increasing order. For example, 
the length of LIS for {10, 22, 9, 33, 21, 50, 41, 60, 80} is 6 and LIS is {10, 22, 33, 50, 60, 80}.
longestIncSubs(arr[4]) = 1+max(longestIncSubs(4-1)) this is the recursive approach but this will have overlapping subproblems
Hence we take memoized bottom up DP approach.
*/
class Solution
{
    static int longestIncSubs(int[] arr){ // TC - O(n2)
        int n = arr.length;
        if(n == 0) return 0;
        int[] lenArr = new int[n];
        lenArr[0] = 1;
        int ans = 0; //this has the max/longest length of any subsequence throughout the arr
        for(int i = 1;i<n;i++){
            lenArr[i] =1; //any element on its own without any support has length 1 since its largest in itself
            for(int j = 0;j<i;j++){
                if(arr[i]>arr[j]){
                    lenArr[i] = Math.max(lenArr[i], lenArr[j]+1);
                }
            }
            if(lenArr[i]>ans) ans = lenArr[i];
        }
        return ans;
    }
	
	static int ceilIndex(int[] a , int r, int l, int key){
        
        while(r > l+1){
            int m = l + (r-l)/2;
            
            if(key > a[m]){
                l = m;
            }else r = m;
        }
        return r;
    }
    
    
    static int longestIncSubs(int[] arr){ // TC - O(nlogn)
        
        int[] a = new int[arr.length];
        a[0] = arr[0];
        int len =1;
        
        for(int i = 1;i<arr.length;i++){
            
            if(arr[i]<arr[0]){
                arr[0] = arr[i];
                
            }
            else if(arr[i]>arr[len-1]){
                arr[len++] = arr[i];
            }else{
                arr[ceilIndex(a, len-1, -1, arr[i])] = arr[i];
            }
        }
        
        return len;
    }
    
	public static void main (String[] args) throws java.lang.Exception
	{
		System.out.println(longestIncSubs(new int[]{3, 10, 2, 1, 20}));
	}
}
