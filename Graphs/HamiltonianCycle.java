/*
Hamiltonian Path in an undirected graph is a path that visits each vertex exactly once. 
A Hamiltonian cycle (or Hamiltonian circuit) is a Hamiltonian Path such that 
there is an edge (in the graph) from the last vertex to the first vertex of the Hamiltonian Path.
We use backtracking to solve here.
TC-O(n2 * 2^n)
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
static boolean isHamCycle(int[][] graph, boolean[] visited, int[] path, int currPos){

if(currPos == graph.length){
if(graph[path[currPos-1]][path[0]] == 1) return true;
else return false;
}

for(int v = 1; v<graph.length; v++){

if(!visited[v] && graph[path[currPos-1]][v] > 0){
visited[v] = true;
path[currPos] = v;
if(isHamCycle(graph, visited, path, currPos+1)) return true;
path[currPos]  = -1;
visited[v] = false;
}
}
return false;
}

static boolean hasHamCycle(int[][] graph){

boolean[] visited = new boolean[graph.length];
int[] path = new int[graph.length];
Arrays.fill(path, -1);
path[0] = 0;
visited[0] = true;

return isHamCycle(graph, visited, path, 1);
}


	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		int[][] graph = {{0, 1, 0, 1, 0}, 
            {1, 0, 1, 1, 1}, 
            {0, 1, 0, 0, 1}, 
            {1, 1, 0, 0, 1}, 
            {0, 1, 1, 1, 0}, 
        };  
        System.out.println(hasHamCycle(graph)); //returns true
	}
}
