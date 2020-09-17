/*
Schedule jobs in such way that the resultant profit is maximum.
Each job is of type 'Job' which has start time, finish time and a profit associated with it.
We can not schedule/start a new job untill the ongoing job finishes.
Here we use DP to solve the problem considering two cases -one with including the job and other without including job
and compare which gives max profit.
We use binary search method to check if we can schedule after some previous/last job which has finished. It returns us
an index at which we can schedule it. Then we add up the prevalent profit at that index in the dp array and add up the current job profit.
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Job 
{ 
    int start, finish, profit; 
  
    // Constructor 
    Job(int start, int finish, int profit) 
    { 
        this.start = start; 
        this.finish = finish; 
        this.profit = profit; 
    } 
} 
class Solution
{
    
    static int binarySearch(Job[] jobs, int index){

       int start = 0; int end = index-1;

      while(start<=end){
             int mid = start + (end-start)/2;

            if(jobs[mid].finish <= jobs[index].start){
                 if(jobs[mid+1].finish <= jobs[index].start) start = mid+1;
                 else return mid;

           }else end = mid-1;

       }
    return -1;
}

static int maxProfit(Job[] jobs){

      int[] dp = new int[jobs.length];
      dp[0] = jobs[0].profit;

      for(int i =1;i<jobs.length;i++){
            
          int inclProf = jobs[i].profit;
          int l = binarySearch(jobs, i);
          if(l != -1){
              inclProf += dp[l];
           }

         dp[i] = Math.max(dp[i-1], inclProf);
          
    }
 return dp[jobs.length-1];
}

	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Job jobs[] = {new Job(1, 2, 50), new Job(3, 5, 20), 
                      new Job(6, 19, 100), new Job(2, 100, 200)}; 
  
        System.out.println("Optimal profit is " + maxProfit(jobs)); // prints 250
	}
}
