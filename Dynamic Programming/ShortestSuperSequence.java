/*
SuperSequence is a one string which has both given strings as subsequnce. We need to find the shortest ss from two given strings.
Longest SS will be both the strings added simply.
For finding shortest, we use DP and concept of LCS(Longest Common Subsequnce).
TC - O(n2)
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
    
static String printSS(String str1, String str2){

int[][] dp = new int[str1.length()+1][str2.length()+1];

for(int i = 1;i<str1.length()+1;i++){

for(int j = 1;j<str2.length()+1;j++){

if(str1.charAt(i-1) == str2.charAt(j-1)) dp[i][j] = dp[i-1][j-1]+1;
else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);

}
}

String ss = "";

int i = str1.length(); int j = str2.length();
while(i>0 && j>0){

if(str1.charAt(i-1) == str2.charAt(j-1)){
ss += str1.charAt(i-1);
i--; j--;
}else{

if(dp[i][j-1] > dp[i-1][j]){
 ss += str2.charAt(j-1);
j--;
}else{
ss += str1.charAt(i-1);
i--;
}
}
}

while(i>0){
    ss += str1.charAt(i-1);
    i--;
}
while(j>0){
    ss += str2.charAt(j-1);
    j--;
}

StringBuilder sb = new StringBuilder(ss);

return sb.reverse().toString();
}

	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		System.out.println(printSS("abcdef","defghijk")); //prints "abcdefghijk"
	}
}
