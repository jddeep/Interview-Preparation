/* Detect if there exists a cycle in the given graph.
  Depth First Traversal can be used to detect a cycle in a Graph. DFS for a connected graph produces a tree. 
  There is a cycle in a graph only if there is a back edge present in the graph.
  A back edge is an edge that is from a node to itself (self-loop) or one of its ancestor in the tree produced by DFS.
  To detect a back edge, we can keep track of vertices currently in recursion stack of function for DFS traversal. 
  If we reach a vertex that is already in the recursion stack, then there is a cycle in the tree. 
  The edge that connects current vertex to the vertex in the recursion stack is a back edge. 
  We can use an auxiliary array say, recStack[] to keep track of vertices in the recursion stack.
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Graph {
    
    List<List<Integer>> graph;
    int vertices;
    
    public Graph(int v){
        this.graph = new ArrayList<>();
        this.vertices = v;
    }
    
    boolean isCyclicUtil(boolean[] visited, boolean recStack[], int i){
        
        if(recStack[i]) return true;
        
        if(visited[i]) return false;
        
        visited[i] = true;
        recStack[i] = true;
        
        List<Integer> nodes = this.graph.get(i);
        for(int node: nodes){
            if(isCyclicUtil(visited, recStack, node)) return true;
        }
        
        recStack[i] = false;
        
        return false;
    }
    
    boolean isCyclic(){
        
        boolean visited[] = new boolean[this.vertices];
        boolean recStack[] = new boolean[this.vertices];
        
        for(int i = 0;i<this.vertices;i++){
            if(isCyclicUtil(visited, recStack, i)) return true;
        }
        
        return false;
    }
}


class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Graph gr = new Graph(4);
		
		gr.graph.add(0, Arrays.asList(1,2));
		gr.graph.add(1, Arrays.asList(2));
		gr.graph.add(2, Arrays.asList(0,3));
		gr.graph.add(3, Arrays.asList(3));
	  System.out.println(gr.isCyclic());
	}
}
