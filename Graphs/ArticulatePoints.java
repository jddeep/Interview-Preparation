/*
A vertex in an undirected connected graph is an articulation point (or cut vertex) if and only if removing it (and edges through it) disconnects the graph.
Articulation points(APs) represent vulnerabilities in a connected network – single points whose failure would split the network into 2 or more disconnected components. 
They are useful for designing reliable networks.
For a disconnected undirected graph, an articulation point is a vertex removing which increases the number of connected components.

A node can be an AP under two cases:
1. If node is root and has more than 1 children.
2. u is not the root of DFS tree and it has a child v such that no vertex in the subtree rooted with v has a back edge to one of the ancestors (in DFS tree) of u.


We do DFS traversal of the given graph with additional code to find out Articulation Points (APs). 
In DFS traversal, we maintain a parent[] array where parent[u] stores parent of vertex u.
Among the above mentioned two cases, the first case is simple to detect. For every vertex, count children.
If currently visited vertex u is root (parent[u] is NIL) and has more than two children, print it.

How to handle the second case? The second case is trickier. We maintain an array disc[] to store discovery time of vertices. 
For every node u, we need to find out the earliest visited vertex (the vertex with minimum discovery time) that can be reached from subtree rooted with u. 
So we maintain an additional array low[] which is defined as follows.
low[u] = min(disc[u], disc[w]) 
where w is an ancestor of u
*/
import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{

static class Graph {

List<List<Integer>> graph;
int vertices;
int time;

Graph(int n){
  this.vertices = n;
  this.time = 0;
  this.graph = new ArrayList<>();
  for(int i = 0; i<n;i++){
     graph.add(i, new ArrayList<>());
}
}

void calculateAP(boolean[] ap, int[] disc, int[] low, int[] parent, boolean[] visited, int u){
    
    int children = 0;
    disc[u] = low[u] = time++;
    visited[u] = true;
    
    List<Integer> nodes = this.graph.get(u);
    
    for(int node: nodes){
        
        if(!visited[node]){
            
            children++;
            parent[node] = u;
            calculateAP(ap, disc, low, parent, visited, node);
            
            low[u] = Math.min(low[u], low[node]);
            
            if(children >= 2 && parent[u] == -1)
              ap[u] = true;
              
            if(parent[u] != -1 && low[node]>=disc[u])
              ap[u] = true;
              
            
        }else if(parent[u] != node)
          low[u] = Math.min(low[u], disc[node]);
    }
}
}

    
	public static void main (String[] args) throws java.lang.Exception
	{
                     
     Graph graphObj = new Graph(5);

     graphObj.graph.add(0, Arrays.asList(2,3));
     graphObj.graph.add(1, Arrays.asList(0));
     graphObj.graph.add(2, Arrays.asList(1));
     graphObj.graph.add(3, Arrays.asList(4));

     boolean[] visited = new boolean[graphObj.vertices];
     boolean[] ap = new boolean[graphObj.vertices];
     int[] disc = new int[graphObj.vertices];
     int[] parent = new int[graphObj.vertices];
     int[] low = new int[graphObj.vertices];
     
     Arrays.fill(parent, -1);
     
     for(int i = 0; i<graphObj.vertices; i++){
         if(!visited[i])
         graphObj.calculateAP(ap, disc, low, parent, visited, i);
     }
     
     for(int i = 0;i<ap.length; i++){
         if(ap[i]) System.out.println(i+" ");
     }
	}
}
