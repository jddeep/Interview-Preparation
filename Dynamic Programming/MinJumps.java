import java.util.*;
import java.lang.*;
import java.io.*;

/*
Given an array of integers where each element represents the max number of steps that can be made forward from that element. 
Write a function to return the minimum number of jumps to reach the end of the array (starting from the first element).
If an element is 0, then cannot move through that element.
jumps[] has min jumps required from to jump from arr[0] to arr[i]
*/
class Solution
{
    static int minJumps(int[] arr){
        int n = arr.length;
        if(n == 0) return 0;
        int[] jumps = new int[n];
        
        jumps[0] = 0; // starting at first index so no jump required
        
        for(int i = 1;i<n;i++){
            jumps[i] = Integer.MAX_VALUE;
            for(int j = 0;j<i;j++){
                if(i<=j+arr[j] && jumps[j] != Integer.MAX_VALUE){
                    jumps[i] = Math.min(jumps[i], jumps[j]+1);
                    break;
                }
            }
        }
        
        return jumps[n-1];
    }
    
	public static void main (String[] args) throws java.lang.Exception
	{
		System.out.println(minJumps(new int[]{1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9})); //prints 3
	}
}
