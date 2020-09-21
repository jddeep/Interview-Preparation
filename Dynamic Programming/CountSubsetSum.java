/*
Count number of subsets from array with provided sum.
No element repition allowed.
TC-O(n2)
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
static int subsetSum(int[] arr, int sum){

int[][] dp = new int[arr.length+1][sum+1];

for(int i = 0;i<dp.length;i++) dp[i][0] = 1;

for(int i = 1;i<sum+1;i++) dp[0][i] = 0;

for(int i = 1;i<dp.length;i++){

for(int j = 1;j<dp[i].length;j++){

     if(arr[i-1]<=j){
           dp[i][j] = dp[i-1][j] + dp[i-1][j-arr[i-1]];
      }else dp[i][j] = dp[i-1][j];
}

}

return dp[arr.length][sum];

}


	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		System.out.println(subsetSum(new int[]{1,2,7,9,4,6,3}, 3)); //prints 2
	}
}
