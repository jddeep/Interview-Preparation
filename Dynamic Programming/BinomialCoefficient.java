import java.util.*;
import java.lang.*;
import java.io.*;

/*
Memoized Bottom up approach. This basically means combinations of set of k elements in n elements.
Order does not matter, just the number of combinations possible - nCk
C(n, k) = C(n-1, k-1) + C(n-1, k) i.e, combinations after removing one out k of elements and without removing to see
how many possible from a even smaller super set of (n-1) elements.
C(n, 0) = C(n, n) = 1 i.e, base cases
*/
class Solution
{
    static int binomialCoefficient(int n, int k){
        int[][] dp = new int[n+1][k+1];
        
        for(int i = 0;i<=n;i++){
            for(int j = 0;j<=Math.min(i, k);j++){
                if(j == 0 || i==j) dp[i][j] = 1;
                else{
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }
            }
        }
        
        return dp[n][k];
    }
    
	public static void main (String[] args) throws java.lang.Exception
	{
		System.out.println(binomialCoefficient(5,2)); //prints 10
	}
}
