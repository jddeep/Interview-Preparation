/* DFS- Depth First Search: This is a type of graph traversal wherein you pick a vertex,
   keep on going exploring one of the subvertices untill there are no remaining unvisited vertices.
   Once you reach the end, you back track and visited other unvisited vertices in the same way.
   DFS is ususally done with Queue/Stack and recursion.
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Graph {
    
    List<List<Integer>> graph;
    Queue<Integer> q;
    
    public Graph(){
        this.graph = new ArrayList<>();
        this.q = new LinkedList<>();
    }
    
    public void dfs(boolean[] visited, int i){
        
        if(visited[i]) return;
        
        System.out.println(i + " ");
        visited[i] = true;
        this.q.add(i);
        
        while(!this.q.isEmpty()){
            int nody = this.q.poll();
            if(nody < this.graph.size()){
                 List<Integer> nodes = this.graph.get(nody);
                 
                 for(int node: nodes){
                     dfs(visited, node);
                 }
                
            }
           
        }
        
    }

}

class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Graph graph = new Graph();
		graph.graph.add(0, Arrays.asList(1, 2));
		graph.graph.add(1, Arrays.asList(2));
		graph.graph.add(2, Arrays.asList(0, 3));
		graph.graph.add(3, Arrays.asList(3));
		boolean[] visited = new boolean[4]; //this size is the last vertex of the graph + 1
		graph.dfs(visited, 2); //source vertex = 2 i.e start traversal from 2
		
	}
}
