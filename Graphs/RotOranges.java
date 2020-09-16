/*
 Given a matrix of dimension m*n where each cell in the matrix can have values 0, 1 or 2 which has the following meaning:

0: Empty cell
1: Cells have fresh oranges
2: Cells have rotten oranges

So we have to determine what is the minimum time required so that all the oranges become rotten. A rotten orange at index [ i,j ] can rot other fresh orange 
at indexes [ i-1, j ], [ i+1, j ], [ i, j-1 ], [ i, j+1 ] (up, down, left and right). If it is impossible to rot every orange then simply return -1.

We will be using BFS for to solve this problem (Queue and iteration)
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
    public static class Pair {

    private final int element0;
    private final int element1;

    public Pair(int element0, int element1) {
        this.element0 = element0;
        this.element1 = element1;
    }

    public int getKey() {
        return element0;
    }

    public int getValue() {
        return element1;
    }

}
    static int rotOranges(int[][] arr){
       
       boolean visited[][] = new boolean[arr.length][arr[0].length];
       
       Queue<Pair> q = new LinkedList<>();
       
       for(int i = 0; i < arr.length; i++){
           for(int j = 0; j<arr[0].length; j++){
               if(arr[i][j] == 2){
                   q.add(new Pair(i, j));
               }
           }
       }
       q.add(new Pair(-1, -1));
       int time = 0;
       Queue<Pair> subq = new LinkedList<>();
       while(!q.isEmpty()){
           
           Pair ij = q.poll();
           int i = ij.getKey();
           int j = ij.getValue();
           
           if(i == -1 && j == -1){
               if(subq.size() == 0) break;
               q  = subq;
               q.add(new Pair(-1, -1));
               subq = new LinkedList<>();
               time++;
               continue;
           }
           
           if(!visited[i][j]){
                   if(i+1 < arr.length && arr[i+1][j] == 1){
                       arr[i+1][j] = 2;
                       subq.add(new Pair(i+1, j));
                   }
                   if(i-1 >= 0 && arr[i-1][j] == 1){
                       arr[i-1][j] = 2;
                       subq.add(new Pair(i-1, j));                      
                   }
                   if(j+1 < arr[0].length && arr[i][j+1] == 1){
                       arr[i][j+1] = 2;
                       subq.add(new Pair(i, j+1));
                   }
                   if(j-1>=0 && arr[i][j-1] == 1){
                       arr[i][j-1] = 2;
                       subq.add(new Pair(i, j-1));
                   }
                   
                   visited[i][j] = true;
           }
           
       }
       
       for (int i=0; i<arr.length;i++){
      for (int j=0;j<arr[i].length;j++){
        if(arr[i][j] == 1) return -1;
      }
    }
       
       return time;
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		int[][] arr = new int[][]{ {2, 1, 0, 2, 1},
                     {1, 0, 1, 2, 1},
                     {1, 0, 0, 2, 1}};
                     
        System.out.println(rotOranges(arr));
	}
}
