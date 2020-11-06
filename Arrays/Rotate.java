/*
Using Juggling Algorithm to left rotate given array.
index can be started from end to right rotate as well.
TC - O(n)
SC - O(1)
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
    static int getGcd(int a, int b){
        
        if(b == 0) return a;
        
        return getGcd(b, a%b);
        
    }
    static void rotate(int []arr, int k){
        
        int n = arr.length;
        
        int gcd = getGcd(n, k);
        int index = 0;
        while(gcd-- > 0){
            
            int temp = arr[index];
            int i = index;
            while(true){
                int j = i + k;
                
                if(j >= n) j = j-n;
                
                if(j == index) break;
                
                arr[i] = arr[j];
                i = j;
            }
            arr[i] = temp;
            index++;
        }
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		
		int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
		
		rotate(arr, 3);
		
		System.out.println(Arrays.toString(arr));
	}
}
