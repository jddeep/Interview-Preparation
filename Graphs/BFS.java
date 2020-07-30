/* BFS- Breadth First Search: This is a type of graph traversal wherein you pick a vertex,
   explore all its attached/connected vertices and then move on to the next/sub vertex and
   do the same thing. Don't traverse for or process already visited vertices.
   BFS is ususally done with Queue and iteration.
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
    
    
    public void bfs(boolean[] visited, int i){
        
        visited[i] = true;
        this.q.add(i);
        while(!this.q.isEmpty()){
            int nody = this.q.poll();
            System.out.println(nody + " ");
            if(nody < this.graph.size()){
            List<Integer> nodes = this.graph.get(nody);
            
            for(int node: nodes){
                if(!visited[node]){
                    visited[node] = true;
                    this.q.add(node);
                }
                
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
		graph.graph.add(0, new ArrayList<>()); // No '0' vertex in this graph
		graph.graph.add(1, Arrays.asList(2, 3));
		graph.graph.add(2, Arrays.asList(4, 5));
		graph.graph.add(3, Arrays.asList(5));
		graph.graph.add(4, Arrays.asList(5, 6));
		graph.graph.add(5, Arrays.asList(6));
		boolean[] visited = new boolean[7]; //this size is the last vertex of the graph + 1
// 		Arrays.fill(visited, false);
		graph.bfs(visited, 1); //source vertex = 1 i.e start traversal from 1
		
	}
}
