/*
TSP - Find the minimum cost path through which salesman can travel all cities once and travel back to the starting city.
TSP says that it is given that it consists Hamiltonian cycle, infact multiple. We need to find the minimum cost cycle.
We solve this problem here using backtracking.
TC-O(n2 * 2*n) which is better than brute force with permutations having TC - O(n!).
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
static int tspUtil(int[][] graph, boolean[] visited, int n, int currPos, int cost, int count, int ans){

if(count == n && graph[currPos][0] > 0){
ans = Math.min(ans, cost+graph[currPos][0]);
return ans;
}

for(int v = 0;v<n;v++){

if(!visited[v] && graph[currPos][v] > 0){
visited[v] = true;
ans = tspUtil(graph, visited, n, v, cost+graph[currPos][v], count+1, ans);
visited[v] =false;
}
}
return ans;
}

static int tsp(int[][] graph, int src, int n){
boolean[] visited = new boolean[n];
visited[src] = true;

return tspUtil(graph, visited, graph.length, src, graph[src][src], 1, Integer.MAX_VALUE);

}

	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		int[][] graph = {{0, 10, 15, 20}, 
                         {10, 0, 35, 25}, 
                         {15, 35, 0, 30}, 
                         {20, 25, 30, 0}}; 
        System.out.println(tsp(graph, 0, graph.length)); //starting from 0th indexed node i.e 1st node
	}
}
